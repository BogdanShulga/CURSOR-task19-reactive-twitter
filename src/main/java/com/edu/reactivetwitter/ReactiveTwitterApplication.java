package com.edu.reactivetwitter;

import com.edu.reactivetwitter.config.TwitterAPIConfigurationProperties;
import com.edu.reactivetwitter.model.Tweet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.reactive.function.client.WebClient;
import twitter4j.*;

@SpringBootApplication
@EnableConfigurationProperties(TwitterAPIConfigurationProperties.class)
public class ReactiveTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTwitterApplication.class, args);


        Runnable runnable = () -> {

            System.out.println("before web client");

            /**
             * Method using the <code>WebClient</code> bean to call a specific URL using the <code>uriBuilder.pathSegment()</code>
             * to build the URL. <code>WebClient</code> supports the use of server-sent events (SSE) as well.
             */

            WebClient webClient = WebClient.create("http://localhost:8080/api");
            webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder.pathSegment("organization", "BBCWorld", "tweets").build())
                    .retrieve()
                    .bodyToFlux(Tweet.class)
                    .map(Tweet::toString)
                    .subscribe(System.out::println);
            System.out.println("after web client");
        };

        new Thread(runnable).start();
    }
}
