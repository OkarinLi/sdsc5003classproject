package com.cityu.sdsc5003classproject.entity;
import com.cityu.sdsc5003classproject.entity.Contact;


import lombok.Data;

import java.util.List;

@Data
public class User {
    private int id;
    private String user_name;
    private String password;
    private String telephone;
    private String email;
    private String identity_card;
    private List<Contact> contact;
}
