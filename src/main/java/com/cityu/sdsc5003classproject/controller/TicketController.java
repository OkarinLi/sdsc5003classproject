package com.cityu.sdsc5003classproject.controller;

import com.cityu.sdsc5003classproject.dao.StationDao;
import com.cityu.sdsc5003classproject.dao.TrainDao;
import com.cityu.sdsc5003classproject.entity.Station;
import com.cityu.sdsc5003classproject.entity.Train;
import com.cityu.sdsc5003classproject.util.Result;
import com.cityu.sdsc5003classproject.util.ResultGenerator;
import com.cityu.sdsc5003classproject.util.StringTool;
import org.springframework.web.bind.annotation.*;

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
                                              @RequestParam(value="arrivalStation", required=true) String arrivalStation){
        return (ResultGenerator.genSuccessResult(trainDao.searchTrainByDA(departureStation,arrivalStation)));
    }
}
