package com.bunjang.market.models.summary;

import lombok.Data;

@Data
public class Events {
    private int TotalEvent;
    private int IssueCommentEvent;
    private int PullRequestEvent;
    private int IssuesEvent;
    private int PushEvent;
    private int PullRequestReviewCommentEvent;
}
