package com.bunjang.market.utils;

import com.bunjang.market.models.summary.Summary;

import java.util.Comparator;

public class EventComparator {

    public static class TotalEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getTotalEvent() - o1.getEvents().getTotalEvent();
        }
    }

    public static class IssueCommentEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getIssueCommentEvent() - o1.getEvents().getIssueCommentEvent();
        }
    }

    public static class PullRequestEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getPullRequestEvent() - o1.getEvents().getPullRequestEvent();
        }
    }

    public static class IssuesEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getIssuesEvent() - o1.getEvents().getIssuesEvent();
        }
    }

    public static class PushEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getPushEvent() - o1.getEvents().getPushEvent();
        }
    }

    public static class PullRequestReviewCommentEvent implements Comparator<Summary> {
        @Override
        public int compare(Summary o1, Summary o2) {
            return o2.getEvents().getPullRequestReviewCommentEvent() - o1.getEvents().getPullRequestReviewCommentEvent();
        }
    }
}
