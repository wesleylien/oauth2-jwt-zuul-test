package com.example.authserver1.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

public class CustomJwtAccessTokenConverter extends JwtAccessTokenConverter {

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
			
		final Map<String, Object> additionalInfo = new HashMap<>();
//		if(authentication.getOAuth2Request().getGrantType().equalsIgnoreCase("password")) {
//			User user1 = (User) authentication.getPrincipal();
//			User user2 = (User) authentication.getUserAuthentication().getPrincipal();
//			additionalInfo.put("user1 ", user1);
//			additionalInfo.put("user2 ", user2);
//        }
		additionalInfo.put("user", "user_1");
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return super.enhance(accessToken, authentication);
	}	
}
