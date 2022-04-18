package com.piyush.rest.basic.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration //We need to tell spring that this is a spring configuration file
@EnableWebSecurity //Tells spring this configuration fine has Spring configuration for Enable we security  ||These two anotations work together as one indicates a configuration file and the other declares for who
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable(); //This disables cross site request forgery tokens  --- we use JWT to deal with csrf vulnerability
		http.authorizeRequests((requests) -> requests.antMatchers(HttpMethod.OPTIONS,"/**").permitAll().anyRequest().authenticated()); //Here we indicate if we recive an options request to any url we want to allow it
		//http.formLogin();
		http.httpBasic();
	}
}
