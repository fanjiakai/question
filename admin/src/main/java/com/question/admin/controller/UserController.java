package com.question.admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.model.req.UserReq;
import com.question.admin.model.req.UserSaveReq;
import com.question.admin.model.view.UserView;
import com.question.admin.service.UserService;
import com.question.common.annotation.WebLog;
import com.question.common.response.ResponseJson;
import com.question.common.utils.SmartContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:55
 */
@RequestMapping("user")
@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;


    @WebLog(value = "查询所有用户列表")
    @GetMapping()
    public ResponseJson list(){
        List<UserView> list = userService.getAll();
        return ResponseJson.newResponseJson(list);
    }

    @WebLog(value = "分页查询所有用户列表")
    @GetMapping("pageList")
    public ResponseJson pageList(UserReq userReq){
        PageInfo page = userService.pageList(userReq);
        return ResponseJson.newResponseJson(page);
    }

    @WebLog(value = "新增用户")
    @PostMapping("save")
    public ResponseJson save(@RequestBody UserSaveReq userSaveReq){
        return userService.save(userSaveReq);
    }

    @WebLog(value = "通过用户id查询用户")
    @GetMapping("getUserById")
    public ResponseJson getUserById(UserReq userReq){
        UserView userView = userService.getUserById(userReq);
        return ResponseJson.newResponseJson(userView);
    }
}
