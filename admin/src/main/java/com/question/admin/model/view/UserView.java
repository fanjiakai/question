package com.question.admin.model.view;

import com.question.common.domain.BaseView;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 23:33
 */
@Data
public class UserView extends BaseView {

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
