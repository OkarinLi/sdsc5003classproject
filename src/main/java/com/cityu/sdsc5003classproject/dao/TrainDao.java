package com.cityu.sdsc5003classproject.dao;

import com.cityu.sdsc5003classproject.entity.Train;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainDao {
    //根据出发站和到达站查询车次信息
    List<Train> searchTrainByDA(@Param("departureStation")String departureStation,@Param("arrivalStation")String arrivalStation);
}
