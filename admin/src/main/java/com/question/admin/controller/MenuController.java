package com.question.admin.controller;

import com.github.pagehelper.PageInfo;
import com.question.admin.model.req.MenuSaveReq;
import com.question.admin.model.req.UserReq;
import com.question.admin.model.view.MenuView;
import com.question.admin.model.view.UserView;
import com.question.admin.service.MenuService;
import com.question.admin.service.UserService;
import com.question.common.annotation.WebLog;
import com.question.common.response.ResponseJson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:55
 */
@RequestMapping("menu")
@RestController
@Slf4j
//@CrossOrigin
public class MenuController {

    @Autowired
    private MenuService menuService;

    @WebLog(value = "查询所有菜单列表")
    @GetMapping("listMenu")
    public ResponseJson listMenu(){
        List<MenuView> list = menuService.listMenu();
        return ResponseJson.newResponseJson(list);
    }

    @WebLog(value = "获取树结构菜单列表")
    @GetMapping("menuTree")
//    @PreAuthorize("hasRole('ROLE_aaa')")
    public ResponseJson menuTree() throws Exception {
        List<MenuView> list = menuService.menuTree();
        return ResponseJson.newResponseJson(list);
    }

    @WebLog(value = "新增菜单")
    @PostMapping("save")
    public ResponseJson save(@RequestBody MenuSaveReq menuSaveReq)  {
        return menuService.saveMenu(menuSaveReq);
    }

    @WebLog(value = "新增菜单")
    @PostMapping("edit")
    public ResponseJson edit(@RequestBody MenuSaveReq menuSaveReq)  {
        return menuService.editMenu(menuSaveReq);
    }
}
