package com.mid.maliha.nutritionmicroservice.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/nutrition/recipe/all").permitAll()
                        .requestMatchers("/nutrition/food-nutrition/all").permitAll()
                        .requestMatchers("/populate/food-information").hasAuthority("ADMIN")
                        .requestMatchers("/populate/category-nutrition").hasAuthority("ADMIN")
                        .requestMatchers("/nutrition/recipe/{food}").hasAuthority("USER")
                        .requestMatchers("/nutrition/food-nutrition/{food}").hasAuthority("USER")
                        .requestMatchers("/nutrition/survey").hasAuthority("USER")
                        .requestMatchers("/nutrition/user/survey").hasAuthority("USER")
                        .requestMatchers("/nutrition/recommendations").hasAuthority("USER")
                        .requestMatchers("/nutrition/search/{category}").hasAuthority("USER")
                        .requestMatchers("/nutrition/search-foodId/{foodId}").hasAuthority("ADMIN")
                        .requestMatchers("/nutrition/search-categoryId/{categoryId}").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);


        return http.build();
    }
}
