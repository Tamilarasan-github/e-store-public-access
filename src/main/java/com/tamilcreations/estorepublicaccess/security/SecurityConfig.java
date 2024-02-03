package com.tamilcreations.estorepublicaccess.security;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;



@Configuration
@EnableWebSecurity
public class SecurityConfig 
{
	    @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    	
	    	RequestAttributes reqAttributes = RequestContextHolder.getRequestAttributes();
	    	if(reqAttributes != null)
	    	{
	    		System.out.println("Request Attributes: "+RequestContextHolder.getRequestAttributes().toString());
	    	}            
	    	
	    	http
	    	.csrf((csrf) -> csrf.disable())
	    	.authorizeHttpRequests(
	                auth -> auth
	                      	.requestMatchers("/**").permitAll()
	                      	.anyRequest().authenticated()
	            )
	    	.formLogin(withDefaults())
            .httpBasic(withDefaults());

	    	 
	    	 return http.build();
	    }
	    
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	
	    

}
