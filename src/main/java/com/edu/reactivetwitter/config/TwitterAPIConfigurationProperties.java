package com.edu.reactivetwitter.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "twitter")
@Data
public class TwitterAPIConfigurationProperties {

	@Value("${TWITTER_CONSUMER_KEY}")
	private String consumerKey;

	@Value("${TWITTER_CONSUMER_SECRET}")
	private String consumerSecret;

	@Value("${TWITTER_ACCESS_TOKEN}")
	private String accessToken;

	@Value("${TWITTER_ACCESS_TOKEN_SECRET}")
	private String accessTokenSecret;
}