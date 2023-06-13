package com.bunjang.market.controller;

import com.bunjang.market.models.summary.Summary;
import com.bunjang.market.service.EventsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventsController {

    private final EventsService eventsService;

    @GetMapping("")
    public List<Map> getEvents() {
        return eventsService.getEvents();
    }

    @GetMapping("/summaries")
    public List<Summary> getEventsSummaries() {
        return eventsService.getSummaries();
    }

    @GetMapping("/event-summaries")
    public List<Summary> sortEventSummary(@RequestParam(required = false) String sort) {
        return eventsService.sortEventSummary(sort);
    }

}
