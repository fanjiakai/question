package com.question.admin.model.req;

import com.question.common.domain.BaseReq;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2020/1/16 11:28
 */
@Data
public class UserSaveReq extends BaseReq {

    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 部门
     */
    private String dept;
    /**
     * 角色
     */
    private String role;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 职级
     */
    private String position;
    /**
     * 头像
     */
    private String headPortrait;
}
