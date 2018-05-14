package com.example.gatewayserver.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

import com.example.gatewayserver.service.JWT;
import com.example.gatewayserver.service.OauthService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class Oauth2JwtFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(Oauth2JwtFilter.class);
	
	@Autowired
	private OauthService oauthService;
	
	@Override
	public boolean shouldFilter() {
		return true;
	}
	
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 100;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		String access_token = (String) ctx.get("access_token");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth instanceof OAuth2Authentication) {
			Object details = auth.getDetails();
			if (details instanceof OAuth2AuthenticationDetails) {
				OAuth2AuthenticationDetails oauth = (OAuth2AuthenticationDetails) details;
				String username = (String) ((Map) oauth.getDecodedDetails()).get("user");
				JWT jwt = oauthService.getToken("Basic Y2xpZW50XzE6MTIzNDU2", "password", "user_1", "123456");
				log.info(jwt.getAccess_token());
			}
		}
		return null;
	}

	
	
}
