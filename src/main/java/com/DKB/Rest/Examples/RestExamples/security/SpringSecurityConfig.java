package com.DKB.Rest.Examples.RestExamples.security;

import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

//security only for restAPI s not like web
@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain chain(HttpSecurity http) throws Exception{
//		1) All requests should be authenticated
		http.authorizeHttpRequests(
				auth -> auth.anyRequest().authenticated()
				);
//		2) If a request is not authenticated, a web page is shown
		http.httpBasic(withDefaults());

//		3) CSRF -> POST, PUT
		// http.csrf().disable(); // Deprecated in SB 3.1.x
        http.csrf(csrf -> csrf.disable()); // Starting from SB 3.1.x Using Lambda DSL
		
		return http.build();
	}
}
