package com.cityu.sdsc5003classproject.entity;

import lombok.Data;

@Data
public class Ticket {
    private int id;
    private int train_id;
    private String seat;
    private String travel_time;
    private String ticket_type;
    private float price;
    private String name;
    private String identity_card;
    private int user_id;
    private String sequence;
}
