package com.question.admin.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2020/1/9 19:06
 */
@RestController()
@RequestMapping("demo")
public class DemoController {

    @GetMapping("/normal")
    @PreAuthorize("hasRole('ROLE_NORMAL')")
    public String normal( ) {
//        String allArea = client2Feign.getAllArea();
        return "normal permission test success !!!" ;
    }

    @GetMapping("/login")
    @PreAuthorize("hasRole('ROLE_NORMAL')")
    public String login( ) {
//        String allArea = client2Feign.getAllArea();
        return "login permission test success !!!" ;
    }

    @GetMapping("/medium")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String medium() {
        return "medium permission test success !!!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_aaa')")
    public String admin() {
        return "admin permission test success !!!";
    }

    @GetMapping("/list")
    @PreAuthorize("hasRole('ROLE_bbb')")
    public String list() {
        return "list permission test success !!!";
    }
}
