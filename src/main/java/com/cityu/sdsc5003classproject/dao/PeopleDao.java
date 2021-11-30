package com.cityu.sdsc5003classproject.dao;

import com.cityu.sdsc5003classproject.entity.People;

import java.util.List;

public interface PeopleDao {
    List<People> getAllPeople();

    int insertPeople(People people);

    int updatePeople(People people);

    int deleteById(String id);

    People getPeopleById(String id);
}
