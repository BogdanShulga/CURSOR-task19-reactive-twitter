package com.edu.reactivetwitter.router;

import com.edu.reactivetwitter.service.OrganizationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
@RequiredArgsConstructor
public class TweetRouter {

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
}
