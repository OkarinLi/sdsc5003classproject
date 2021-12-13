package com.cityu.sdsc5003classproject.controller;

import com.cityu.sdsc5003classproject.dao.StationDao;
import com.cityu.sdsc5003classproject.dao.TicketDao;
import com.cityu.sdsc5003classproject.dao.TrainDao;
import com.cityu.sdsc5003classproject.entity.Station;
import com.cityu.sdsc5003classproject.entity.Train;
import com.cityu.sdsc5003classproject.util.Result;
import com.cityu.sdsc5003classproject.util.ResultGenerator;
import com.cityu.sdsc5003classproject.util.StringTool;
import org.springframework.web.bind.annotation.*;
import com.cityu.sdsc5003classproject.entity.Ticket;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class TicketController {
    @Resource
    StationDao stationDao;
    @Resource
    TrainDao trainDao;
    @Resource
    TicketDao ticketDao;
    //查找所有车站
    @GetMapping("/station")
    @ResponseBody
    public Result<List<Station>> queryAll(){
        return ResultGenerator.genSuccessResult(stationDao.getStationList());
    }

    //根据起始站和终点站查询车票
    @GetMapping("/trainTicket")
    @ResponseBody
    public Result<List<Train>> getTrainTicket(@RequestParam(value="departureStation", required=true) String departureStation,
                                              @RequestParam(value="arrivalStation", required=true) String arrivalStation,
                                              @RequestParam(value="train_date",required=true) String train_date
                                              ){
        return (ResultGenerator.genSuccessResult(trainDao.searchTrainByDA(departureStation,arrivalStation,train_date)));
    }

    //购票
    @PostMapping("/ticket")
    @ResponseBody
    public Result<Boolean> insertTicket(@RequestBody Ticket ticket){
        ticketDao.insertTicket(ticket);
        ticketDao.minusOneTicket(ticket);
        return(ResultGenerator.genSuccessResult(true));
    }

    //根据账号id获取该账号的车票信息
    @GetMapping("/ticket")
    @ResponseBody
    public Result<List<Ticket>> getTicketById(@RequestParam(value="user_id", required=true)int user_id){
        return(ResultGenerator.genSuccessResult(ticketDao.searchByUserId(user_id)));
    }

    //退票
    @DeleteMapping("/ticket")
    @ResponseBody
    public Result<Boolean> delete(@RequestBody Ticket ticket){
        ticketDao.deleteById(ticket);
        ticketDao.addOneSeat(ticket);
        return ResultGenerator.genSuccessResult(true);
    }
}
