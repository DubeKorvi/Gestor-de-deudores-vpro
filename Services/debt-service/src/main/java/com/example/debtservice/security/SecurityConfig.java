package com.example.debtservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration() {

        FilterRegistrationBean<JwtFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(jwtFilter);

        // CORRECCIÓN — antes era "/debts/*", "/debts" y nunca interceptaba nada
        // porque el controller responde en /api/v1/debts/**
        registration.addUrlPatterns("/api/v1/debts", "/api/v1/debts/*");

        registration.setOrder(1);
        return registration;
    }
}
