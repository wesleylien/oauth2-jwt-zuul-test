package com.example.gatewayserver.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.util.FileCopyUtils;

@Configuration
@EnableResourceServer
public class Oauth2JwtResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Autowired
	JwtAccessTokenConverter jwtAccessTokenConverter;
	
	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(jwtAccessTokenConverter);
	}
	
	@Bean
	public JwtAccessTokenConverter jwtTokenEnhancer() {
		JwtAccessTokenConverter converter = new CustomJwtAccessTokenConverter();
		Resource resource = new ClassPathResource("public.cert");
		String publicKey = null;
		try {
			publicKey = new String(FileCopyUtils.copyToByteArray(resource.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		converter.setVerifierKey(publicKey);
		return converter;
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().authenticated()
			.and()
			.csrf().disable();
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore());
	}
	
	
}
