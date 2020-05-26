package com.question.common.domain;

import com.question.common.utils.Tool;
import lombok.Data;
import org.apache.commons.lang.StringUtils;

import java.sql.Timestamp;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/12 0:14
 */
@Data
public class BaseReq {

    private int pageNum = 1;
    private int pageSize = 10;

    private String id;
    private String parentId;
    private String insertUser;
    private Timestamp insertDate;
    private String updateUser;
    private Timestamp updateDate;
    private int del = 0;
    private String remark;

    public String getId() {
        if (StringUtils.isBlank(id)){
            id = Tool.generateUuid();
        }
        return id;
    }

    public Timestamp getInsertDate() {
        if (insertDate == null){
            insertDate = new Timestamp(System.currentTimeMillis());
        }
        return insertDate;
    }

    public String getParentId() {
        if (StringUtils.isBlank(parentId)){
            parentId = "-1";
        }
        return parentId;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public Timestamp getUpdateDate() {
        if (updateDate == null){
            updateDate = new Timestamp(System.currentTimeMillis());
        }
        return updateDate;
    }
}
