package com.question.admin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.feign.RedisFeign;
import com.question.admin.model.req.DictReq;
import com.question.admin.model.view.DictView;
import com.question.admin.service.DictService;
import com.question.common.annotation.WebLog;
import com.question.common.response.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:20
 */
@RequestMapping("dict")
@RestController
@Slf4j
public class DictController {

    @Autowired
    private RedisFeign redisFeign;

    @Autowired
    private DictService dictService;

    @WebLog(value = "查询所有字典列表")
    @GetMapping("listDict")
    public ResponseJson listDict(DictReq dictReq){
        PageInfo page = dictService.listDict(dictReq);
        return ResponseJson.newResponseJson(page);
    }
}
