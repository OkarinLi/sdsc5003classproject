package com.cityu.sdsc5003classproject.dao;
import com.cityu.sdsc5003classproject.entity.Contact;

import java.util.List;


public interface ContactDao {
    List<Contact> searchByUserId(int user_id);
    int deleteById(int id);
    int insertContact(Contact contact);
}
