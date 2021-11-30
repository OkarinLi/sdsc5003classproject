package com.cityu.sdsc5003classproject.controller;

import com.cityu.sdsc5003classproject.dao.UserDao;
import com.cityu.sdsc5003classproject.entity.Contact;
import com.cityu.sdsc5003classproject.entity.People;
import com.cityu.sdsc5003classproject.entity.User;
import com.cityu.sdsc5003classproject.dao.ContactDao;
import com.cityu.sdsc5003classproject.util.Result;
import com.cityu.sdsc5003classproject.util.ResultGenerator;
import com.cityu.sdsc5003classproject.util.StringTool;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class UserController {
    @Resource
    UserDao userDao;
    @Resource
    ContactDao contactDao;


    //根据用户id查询信息
    @GetMapping("/user")
    public Result<User> queryByName(int user_id){
       System.out.println(user_id);
        User userInfo = userDao.getUserById(user_id);
        List<Contact> conInfo = contactDao.searchByUserId(user_id);
        userInfo.setContact(conInfo);
//        System.out.println(user_id);
        return ResultGenerator.genSuccessResult(userInfo);
    }
    //注册
    @PostMapping("/user")
    @ResponseBody
    public Result<Boolean> insert(@RequestBody User user){
        if(StringTool.isNotBlank(user.getUser_name())&&StringTool.isNotBlank(user.getPassword())){
            userDao.insertUser(user);
            return ResultGenerator.genSuccessResult(true);
        }
        System.out.println("信息有误");
        return ResultGenerator.genFailResult("缺少参数");
    }
    //登录
    @PostMapping("/login")
    @ResponseBody
    public Result<User> login(@RequestBody User user) {
        if(StringTool.isNotBlank(user.getUser_name())&&StringTool.isNotBlank(user.getPassword())){
            User current =userDao.search(user);

            if(current==null){
                return ResultGenerator.genFailResult("Login fail");
            }else{
                return ResultGenerator.genSuccessResult(current);
            }
        }
        System.out.println("信息有误");
        return ResultGenerator.genFailResult("缺少参数");
    }
    //修改个人信息
    @PutMapping("/user")
    @ResponseBody
    public Result<Boolean> update(@RequestBody User user){

        if(user==null){
            return ResultGenerator.genFailResult("缺少参数");
        }
        userDao.updateUser(user);
        return ResultGenerator.genSuccessResult(true);
    }
    //删除联系人
    @DeleteMapping("/contact")
    @ResponseBody
    public Result<Boolean> delete(@RequestBody Contact contact){
            contactDao.deleteById(contact.getId());
            return ResultGenerator.genSuccessResult(true);
    }
    //新增联系人
    @PostMapping("/contact")
    @ResponseBody
    public Result<Boolean> insertContact(@RequestBody Contact contact){
            contactDao.insertContact(contact);
            return ResultGenerator.genSuccessResult(true);
    }

}


