package com.example.gatewayserver.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2Authentication extractAuthentication(Map<String, ?> map) {
		OAuth2Authentication oauth2Authentication = super.extractAuthentication(map);
		oauth2Authentication.setDetails(map);
		return oauth2Authentication;
	}
}
