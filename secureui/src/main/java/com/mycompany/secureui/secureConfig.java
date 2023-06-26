package com.mycompany.secureui;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import  static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class secureConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception
    {
        System.out.println("In security filter chain.....");

        httpSecurity.authorizeHttpRequests((authz)->  authz
        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
        .anyRequest().authenticated())
        .oauth2Login(withDefaults());

        return httpSecurity.build();

   }

    }
    
