package com.question.common.domain;

import lombok.Data;

import java.sql.Timestamp;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/12 0:36
 */
@Data
public class BaseEntity {

    private String id;
    private String insertUser;
    private Timestamp insertDate;
    private String updateUser;
    private Timestamp updateDate;
    private int del;
    private String remark;

}
