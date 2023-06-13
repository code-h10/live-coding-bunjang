package com.bunjang.market.service;

import com.bunjang.market.models.summary.Summary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EventsServiceTest {


    @Autowired private EventsService eventsService;

    @Test
    public void test() {
        List<Summary> s = eventsService.sortEventSummary("PullRequestReviewCommentEvent");

        for (Summary aa : s) {
            System.out.println(aa);
        }
    }

}