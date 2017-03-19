package com.assignment;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.assignment.dto.LoginItem;
import com.assignment.dto.TokenItem;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired(required=true)
	private HttpServletRequest request;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.authorizeRequests()
				.antMatchers("/css/**", "/login").permitAll()
				.antMatchers("/projectexplorer", "/viewproject").authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/projectexplorer", true)
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.authenticationProvider(new AuthenticationProvider() {
			
			@Override
			public boolean supports(Class<?> authentication) {
				return authentication.equals(UsernamePasswordAuthenticationToken.class);
			}
			
			@Override
			public Authentication authenticate(Authentication authentication) throws AuthenticationException {
				
				RestTemplate template = new RestTemplate();
				try {
					String name = authentication.getName();
			        String password = authentication.getCredentials().toString();
			        
					TokenItem item = template.postForObject("http://userservice.staging.tangentmicroservices.com:80/api-token-auth/", new LoginItem(name, password), TokenItem.class);
					request.getSession().setAttribute("Token", item.getToken());
					
					return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<>());
				}
				catch (HttpClientErrorException e) {
					return null;
				}
			}
		});
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		web.ignoring().antMatchers("/js/**", "/webjars/**");
	}
}
