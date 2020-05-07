package com.example.ZuulServer.security;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Data;

@Component
@ConfigurationProperties("sicurezza")
@Data
public class JwtConfig
{
	private String uri;
	private String header;
	private String prefix;
	private String secret;
	private int expiration;
}