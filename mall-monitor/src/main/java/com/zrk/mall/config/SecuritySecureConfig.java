package com.zrk.mall.config;

import com.zrk.mall.filter.CustomCsrFilter;
import de.codecentric.boot.admin.server.config.AdminServerProperties;
import jakarta.servlet.DispatcherType;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.UUID;

/**
 * Spring Boot Admin的Security相关配置
 * Created by zrk on 2026/1/3
 */
@Configuration(proxyBeanMethods = false)
public class SecuritySecureConfig {

    private final AdminServerProperties adminServerProperties;

    private final SecurityProperties securityProperties;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties, SecurityProperties securityProperties) {
        this.adminServerProperties = adminServerProperties;
        this.securityProperties = securityProperties;
    }

     @Bean
    protected SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminServerProperties.path("/"));
        http.authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                .requestMatchers(new AntPathRequestMatcher(this.adminServerProperties.path("/assets/**")))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher(this.adminServerProperties.path("/actuator/**")))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher(this.adminServerProperties.path("/actuator/health")))
                .permitAll()
                .requestMatchers(new AntPathRequestMatcher(this.adminServerProperties.path("/login")))
                .permitAll()
                .dispatcherTypeMatchers(DispatcherType.ASYNC)
                .permitAll()
                .anyRequest()
                .authenticated())
                .formLogin((formLogin) -> formLogin.loginPage(this.adminServerProperties.path("/login")).successHandler(successHandler))
                .logout((logout) -> logout.logoutUrl(this.adminServerProperties.path("/logout")))
                .httpBasic(Customizer.withDefaults());
        http.addFilterAfter(new CustomCsrFilter(), BasicAuthenticationFilter.class)
                .csrf((csrf) -> csrf.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
                        .csrfTokenRequestHandler(new CsrfTokenRequestAttributeHandler())
                        .ignoringRequestMatchers(
                                new AntPathRequestMatcher(this.adminServerProperties.path("/instances"), "POST"),
                                new AntPathRequestMatcher(this.adminServerProperties.path("/instances/*"), "DELETE"),
                                new AntPathRequestMatcher(this.adminServerProperties.path("/actuator/**"))
                        ));
        http.rememberMe((rememberMe) -> rememberMe.key(UUID.randomUUID().toString()).tokenValiditySeconds(1209600)); // 14天
        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsManager(PasswordEncoder passwordEncoder) {
        UserDetails user = User.withUsername("zrk")
                .password(passwordEncoder.encode("Aa65602842"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
