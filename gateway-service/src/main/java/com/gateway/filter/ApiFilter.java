package com.gateway.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import com.gateway.GatewayServiceApplication;
import com.gateway.routs.EndpointsRouts;
import com.gateway.utils.JwtUtils;

@Configuration 
public class ApiFilter extends AbstractGatewayFilterFactory<ApiFilter.Config> {

  //  private final GatewayServiceApplication gatewayServiceApplication;

    @Autowired
    private JwtUtils jwtUtil;
    
    @Autowired
    private EndpointsRouts endpointsRouts;

    public ApiFilter(GatewayServiceApplication gatewayServiceApplication) {
        super(Config.class);
       // this.gatewayServiceApplication = gatewayServiceApplication;
    }
    String jwtToken = null;

	@Override
	public GatewayFilter apply(Config config) { 
		
		return ((exchange, chain)-> {
			if(endpointsRouts.isPublic.test(exchange.getRequest())) {
				if(exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION))
				{
					throw new RuntimeException("Please provide Token");
					
				}
				
				
				//String jwtTokenBearer = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				String jwtTokenBearer = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
				if(jwtTokenBearer != null && jwtTokenBearer.startsWith("Bearer "))
				{
					jwtToken = jwtTokenBearer.substring(7);
				}
				jwtUtil.validateToken(jwtToken);
			}
			
			
			return chain.filter(exchange);
		});
		
	}
	
	public static final class Config
	{
		
	}

	
  
}