package com.cityu.sdsc5003classproject.entity;

import lombok.Data;

@Data
public class Contact {
    int id;
    int user_id;
    String name;
    String telephone;
    String identity_card;
}
