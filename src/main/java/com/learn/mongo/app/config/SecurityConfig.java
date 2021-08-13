package com.learn.mongo.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

//@Configuration
////@EnableWebSecurity
////@EnableGlobalMethodSecurity(
////        prePostEnabled = true,
////        proxyTargetClass = true,
////        securedEnabled = true,
////        jsr250Enabled = true)
//
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors();
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .csrf()
//                .disable();
//                .formLogin()
//                .disable()
//                .httpBasic()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/api/v1/**").permitAll()
//                .antMatchers("/api/glee/**").hasAnyAuthority("ADMIN", "USER")
//                .antMatchers("/api/users/**").hasAuthority("ADMIN")
//                .antMatchers("/api/**").authenticated()
//                .anyRequest().authenticated();
                //.and().exceptionHandling().authenticationEntryPoint(new RestAuthenticationEntryPoint());
    //}
//}