package com.edu.reactivetwitter.controller;

import com.edu.reactivetwitter.model.Tweet;
import com.edu.reactivetwitter.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class TwitterController {

    private final OrganizationService organizationService;

    @GetMapping("/tweets/{organization}")
    public Flux<Tweet> getTweetsFrom(@PathVariable String organization) {

        return organizationService.findTweets(organization);
    }
}
