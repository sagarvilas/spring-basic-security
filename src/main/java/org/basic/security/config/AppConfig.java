package org.basic.security.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class AppConfig {
	
	@Value("${security.user.name}")
	private String user;
	
	@Value("${security.user.password}")
	private String password;
	

	@Bean
	public WebSecurityConfigurerAdapter securityConfigurer() {
		Map<String, String> creds = new HashMap();
		creds.put(user, password);
		return new BasicSecurityConfigurer(creds);
	}
}
