package com.example.demo.security;

import com.example.demo.services.userService.UserService;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;
import java.util.Arrays;
import java.util.Collections;

@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder bcryptPasswordEncoder;


    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors().configurationSource(request -> {
      CorsConfiguration cors = new CorsConfiguration();
      cors.setAllowedOrigins(List.of("http://localhost:3000", "http://127.0.0.1:80", "http://example.com"));
      cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
      cors.setAllowedHeaders(List.of("*"));
      return cors;
    }).and().headers().frameOptions().disable().and().csrf().disable().authorizeRequests()
        .antMatchers(HttpMethod.GET, "/h2-console/**").permitAll()
        .antMatchers(HttpMethod.GET, "/users").permitAll()
        .antMatchers(HttpMethod.GET, "/posts").permitAll()
        .antMatchers(HttpMethod.POST, "/posts").permitAll()
        .antMatchers(HttpMethod.POST, "/h2-console/**").permitAll()
        .antMatchers(HttpMethod.POST, "/users").permitAll()
        .antMatchers(HttpMethod.POST, SecurityConstants.SIGN_UP_URL).permitAll()
        .anyRequest().authenticated()
        .and()
            .addFilter(new JWTAuthenticationFilter(authenticationManager()))
            .addFilter(new JWTAuthorizationFilter(authenticationManager()))
        // this disables session creation on Spring Security
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
    
}
