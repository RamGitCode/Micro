package com.gateway.routs;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class EndpointsRouts 
{
	
 
	public static final List<String> endpoints = List.of("/auth/generateToken","/eureka");
	
	/*
	 * public Predicate<ServerHttpRequest> isPublic = serverHttpRequest ->
	 * endpoints.stream() .noneMatch(publicUris ->
	 * serverHttpRequest.getURI().getPath().contains(endpoints));
	 */
	
	public Predicate<ServerHttpRequest> isPublic = serverHttpRequest ->
    endpoints.stream()
            .anyMatch(publicUri -> serverHttpRequest.getURI().getPath().contains(publicUri));

}
