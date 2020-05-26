package com.question.admin.controller;

import com.github.pagehelper.PageInfo;
import com.question.admin.model.req.IconReq;
import com.question.admin.model.req.IconSaveReq;
import com.question.admin.model.req.MenuSaveReq;
import com.question.admin.model.view.IconView;
import com.question.admin.model.view.MenuView;
import com.question.admin.service.IconService;
import com.question.admin.service.MenuService;
import com.question.common.annotation.WebLog;
import com.question.common.response.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:55
 */
@RequestMapping("icon")
@RestController
@Slf4j
public class IconController {

    @Autowired
    private IconService iconService;

    @WebLog(value = "查询所有图标列表")
    @GetMapping("/list")
    public ResponseJson listIcon(IconReq iconReq){
        List<IconView> list = iconService.listIcon(iconReq);
        return ResponseJson.newResponseJson(list);
    }

    @WebLog(value = "分页查询所有图标列表")
    @GetMapping("/pageList")
    public ResponseJson pageList(IconReq iconReq){
        PageInfo page = iconService.pageList(iconReq);
        return ResponseJson.newResponseJson(page);
    }


    @WebLog(value = "同步图标列表")
    @PostMapping("/synch")
    public ResponseJson synchIcon(@RequestBody List<IconSaveReq> icons){
        iconService.synchIcon(icons);
        return ResponseJson.newResponseJson();
    }

}
