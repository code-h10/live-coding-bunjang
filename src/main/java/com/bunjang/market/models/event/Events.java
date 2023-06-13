package com.bunjang.market.models.event;


import lombok.Data;

@Data
public class Events {
    private int id;
    private String type;
    private Actor actor;
}
