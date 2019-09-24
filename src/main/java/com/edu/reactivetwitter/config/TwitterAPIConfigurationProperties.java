package com.edu.reactivetwitter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "twitter")
@Data
public class TwitterAPIConfigurationProperties {

	@Value("${twitter.consumer-key}")
	private String consumerKey;

	@Value("${twitter.consumer-secret}")
	private String consumerSecret;

	@Value("${twitter.access-token}")
	private String accessToken;

	@Value("${twitter.access-token-secret}")
	private String accessTokenSecret;
}