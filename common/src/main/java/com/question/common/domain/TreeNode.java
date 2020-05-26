package com.question.common.domain;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/17 20:44
 */
@Data
public class TreeNode {

    private String id;
    private String parentId;
    private String insertUser;
    private Timestamp insertDate;
    private String updateUser;
    private Timestamp updateDate;
    private int del;
    private String remark;
    private List<TreeNode> children;
}
