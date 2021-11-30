package com.cityu.sdsc5003classproject.controller;

import com.cityu.sdsc5003classproject.dao.PeopleDao;
import com.cityu.sdsc5003classproject.entity.People;
import com.cityu.sdsc5003classproject.util.Result;
import com.cityu.sdsc5003classproject.util.ResultGenerator;
import com.cityu.sdsc5003classproject.util.StringTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class PeopleController {
    @Resource
    PeopleDao peopleDao;

    //查
    @GetMapping("/people")
    @ResponseBody
    public Result<List<People>> queryAll() {
        return ResultGenerator.genSuccessResult(peopleDao.getAllPeople());
    }
    @GetMapping("/people/{id}")
    public Result<People> queryById(@PathVariable("id")String id){
        return ResultGenerator.genSuccessResult(peopleDao.getPeopleById(id));
    }
    //增
    @PostMapping("/people")
    @ResponseBody
    public Result<Boolean> insert(@RequestBody People people){
        if(StringTool.isNotBlank(people.getId())&&StringTool.isNotBlank(people.getName())){
            peopleDao.insertPeople(people);
            return ResultGenerator.genSuccessResult(true);
        }
        System.out.println("信息有误");
        return ResultGenerator.genFailResult("缺少参数");
    }
    //删
    @DeleteMapping("/people/{id}")
    @ResponseBody
    public Result<Boolean> delete(@PathVariable("id")String id){
        System.out.println(id);
        if(StringTool.isNotBlank(id)) {

            peopleDao.deleteById(id);
            return ResultGenerator.genSuccessResult(true);
        }
        return ResultGenerator.genFailResult("缺少参数");
    }
    //改
    @PutMapping("/people")
    @ResponseBody
    public Result<Boolean> update(@RequestBody People people){
        if(people==null||!StringTool.isNotBlank(people.getId())){
            return ResultGenerator.genFailResult("缺少参数");
        }
        peopleDao.updatePeople(people);
        return ResultGenerator.genSuccessResult(true);
    }
}
