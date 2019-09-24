package com.edu.reactivetwitter;

import com.edu.reactivetwitter.component.TweetListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReactiveTwitterApplicationTests {

    @Autowired
    TweetListener tweetListener;



    @Test
    public void contextLoads() {

        tweetListener.run();

    }

}
