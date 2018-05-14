package com.example.microservice1;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping("/hi")
	public String sayHi(Authentication authentication) {
		OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails) authentication.getDetails();
		return (String) ((Map) details.getDecodedDetails()).get("test");
	}
	
//	@RequestMapping("/hi")
//	public String sayHi() {
//		return "hi";
//	}
}
