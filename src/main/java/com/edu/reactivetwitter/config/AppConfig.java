package com.edu.reactivetwitter.config;

import org.springframework.context.annotation.Bean;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.Configuration;

@org.springframework.context.annotation.Configuration
public class AppConfig {

    /**
     * Configuration of Twitter4J including authentication details (OAuth tokens)
     */
    @Bean
    public Configuration configuration(TwitterAPIConfigurationProperties properties) {
        return new ConfigurationBuilder()
                .setOAuthConsumerKey(properties.getConsumerKey())
                .setOAuthConsumerSecret(properties.getConsumerSecret())
                .setOAuthAccessToken(properties.getAccessToken())
                .setOAuthAccessTokenSecret(properties.getAccessTokenSecret())
                .build();
    }
}
