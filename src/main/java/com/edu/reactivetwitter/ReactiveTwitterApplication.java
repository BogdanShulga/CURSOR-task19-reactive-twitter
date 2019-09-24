package com.edu.reactivetwitter;

import com.edu.reactivetwitter.config.TwitterAPIConfigurationProperties;
import com.edu.reactivetwitter.model.Organization;
import com.edu.reactivetwitter.model.Tweet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@SpringBootApplication
@EnableConfigurationProperties(TwitterAPIConfigurationProperties.class)
public class ReactiveTwitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveTwitterApplication.class, args);


        String organizationName = "BBCWorld";
        String hashtag = "Ukraine";

        saveOrganizationToDB(organizationName, hashtag);

        runClient(organizationName);
    }

    private static void saveOrganizationToDB(String organizationName, String hashtag) {

        Organization organization = new Organization();
        organization.setName(organizationName);
        ArrayList<String> technologies = new ArrayList<>();
        technologies.add(hashtag);
        organization.setTechnologies(technologies);

        HttpEntity<Organization> requestBody = new HttpEntity<>(organization);

        RestTemplate restTemplate = new RestTemplate();

        Organization savedOrganization = restTemplate.postForObject("http://localhost:8080/api/organization", requestBody, Organization.class);

        System.out.println(savedOrganization);
    }

    private static void runClient(String organizationName) {
        Runnable runnable = () -> {
            WebClient webClient = WebClient.create("http://localhost:8080/api");
            webClient
                    .get()
                    .uri(uriBuilder -> uriBuilder.pathSegment("organization", organizationName, "tweets").build())
                    .retrieve()
                    .bodyToFlux(Tweet.class)
                    .map(Tweet::toString)
                    .subscribe(System.out::println);
        };

        new Thread(runnable).start();
    }
}
