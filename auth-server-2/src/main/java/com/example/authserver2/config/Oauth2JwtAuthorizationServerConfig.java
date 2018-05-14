package com.example.authserver2.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.builders.InMemoryClientDetailsServiceBuilder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.error.DefaultWebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableAuthorizationServer
public class Oauth2JwtAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;

	// 配置 OAuth2 Client 信息
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("client_1").secret("123456")
//			.resourceIds("oauth_server", "resource_1")
			.scopes("scope_1").authorities("read", "write")
			.authorizedGrantTypes("password", "refersh_token")
			.and()
			.withClient("client_2").secret("123456")
//			.resourceIds("oauth_server", "resource_1")
			.scopes("scope_2").authorities("read", "write")
			.authorizedGrantTypes("client_credentials", "refersh_token");
	}
		
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)			// 使用 grant type 为 password 时需要配置开启
				.tokenStore(jwtTokenSotre())							// oauth2 类型为 jwt 时不需要再 authorization server 上存储 token
				.tokenEnhancer(jwtAccessTokenConverter());				// token converter 在 token 生成时进行 enhance
	}
	 
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")				// 对获取 token 不拦截
				.checkTokenAccess("isAuthenticated()");		// 验证获取 Token 的验证信息
	}
	
	@Bean
	public TokenStore jwtTokenSotre() {
		return new JwtTokenStore(jwtAccessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		// 使用自定义 JwtAccessTokenConverter 子类，在 token 增加 addtional information
		JwtAccessTokenConverter converter = new CustomJwtAccessTokenConverter();
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource("test2.jks"), "123456".toCharArray());		
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair("test2"));
		return converter;
	}
}
