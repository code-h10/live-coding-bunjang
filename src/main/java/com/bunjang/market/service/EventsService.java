package com.bunjang.market.service;


import com.bunjang.market.models.summary.Events;
import com.bunjang.market.models.summary.Summary;
import com.bunjang.market.utils.EventComparator;
import lombok.RequiredArgsConstructor;

import java.util.*;

import static java.util.Objects.isNull;


@RequiredArgsConstructor
public class EventsService {

    private final List<Map> events;

    public List<Map> getEvents() {
        return events;
    }

    public List<Summary> getSummaries() {
        List<Summary> result = new ArrayList<>();
        Summary summary = null;
        Map<String, Integer> eventSum = new HashMap<>();
        Set<String> login = new HashSet<>();

        for (Map event : events) {
            Map actors = (Map) event.get("actor");
            String key = actors.get("login").toString() + event.get("type").toString();
            eventSum.put(key, eventSum.getOrDefault(key, 0) + 1);
            login.add(actors.get("login").toString());
        }


        for (String l : login) {

            int issueCommentEvent = isNull(eventSum.get(l+"IssueCommentEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"IssueCommentEvent").toString());
            int pullRequestEvent = isNull(eventSum.get(l+"PullRequestEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"PullRequestEvent").toString());
            int issuesEvent = isNull(eventSum.get(l+"IssuesEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"IssuesEvent").toString());
            int pullRequestReviewCommentEvent = isNull(eventSum.get(l+"PullRequestReviewCommentEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"PullRequestReviewCommentEvent").toString());
            int pushEvent = isNull(eventSum.get(l+"PushEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"PushEvent").toString());
            int watchEvent = isNull(eventSum.get(l+"WatchEvent")) ? 0 : Integer.parseInt(eventSum.get(l+"WatchEvent").toString());

            Events events = new Events();
            events.setTotalEvent(issueCommentEvent+pullRequestEvent+issuesEvent+pullRequestReviewCommentEvent+pushEvent);
            events.setIssueCommentEvent(issueCommentEvent);
            events.setPullRequestEvent(pullRequestEvent);
            events.setIssuesEvent(issuesEvent);
            events.setPullRequestReviewCommentEvent(pullRequestReviewCommentEvent);
            events.setPushEvent(pushEvent);

            summary = new Summary();
            summary.setLogin(l);
            summary.setEvents(events);
            result.add(summary);
        }

        return result;
    }

    public List<Summary> sortEventSummary(String sort) {

        List<Summary> result = getSummaries();
        if ("TotalEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.TotalEvent());
        } else if ("IssueCommentEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.IssueCommentEvent());
        } else if ("PullRequestEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.PullRequestEvent());
        } else if ("IssuesEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.IssuesEvent());
        } else if ("PushEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.PushEvent());
        } else if ("PullRequestReviewCommentEvent".equals(sort)) {
            Collections.sort(result, new EventComparator.PullRequestReviewCommentEvent());
        }
        return result;
    }





}
