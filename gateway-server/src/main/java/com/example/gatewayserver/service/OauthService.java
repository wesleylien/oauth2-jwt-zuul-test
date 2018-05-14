package com.example.gatewayserver.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-auth2")
public interface OauthService {
	@PostMapping(value = "/oauth/token")
	public JWT getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type, @RequestParam("username") String username, @RequestParam("password") String password);
}
