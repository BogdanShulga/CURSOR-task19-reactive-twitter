package com.edu.reactivetwitter.config;

import com.edu.reactivetwitter.service.OrganizationHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.RouterFunction;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.conf.Configuration;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@org.springframework.context.annotation.Configuration
public class AppConfig {

    /**
     * Router function can bu used to define routes for the entire application.
     *
     * @param organizationHandler All handlers should be included.
     * @return A <code>RouterFunction</code> using the <code>route()</code> static function.
     */
    @Bean
    public RouterFunction<?> routerFunction(OrganizationHandler organizationHandler) {
        return route(GET("/api/organization"), organizationHandler::findAll)
                .and(route(POST("/api/organization"), organizationHandler::save))
                .and(route(GET("/api/organization/{name}/tweets"), organizationHandler::findTweets));
    }

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

    /**
     * We can define a <code>WebClient</code> with a generic base URL to use it for all organization API calls.
     */
    @Bean
    public WebClient webClient() {
        return WebClient.create("http://localhost:8080/api");
    }
}
