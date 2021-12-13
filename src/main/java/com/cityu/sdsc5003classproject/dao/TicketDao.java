package com.cityu.sdsc5003classproject.dao;


import com.cityu.sdsc5003classproject.entity.Ticket;

import java.util.List;

public interface TicketDao {
    int insertTicket(Ticket ticket);
    int minusOneTicket(Ticket ticket);
    List<Ticket> searchByUserId(int user_id);
    int deleteById(Ticket ticket);
    int addOneSeat(Ticket ticket);


}
