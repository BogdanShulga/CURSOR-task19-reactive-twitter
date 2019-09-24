package com.edu.reactivetwitter;

import com.edu.reactivetwitter.config.TwitterAPIConfigurationProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TwitterAPIConfigurationProperties.class)
public class ReactiveTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTwitterApplication.class, args);
    }

}
