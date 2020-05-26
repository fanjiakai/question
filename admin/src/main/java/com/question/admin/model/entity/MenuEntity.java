package com.question.admin.model.entity;

import com.question.common.domain.BaseEntity;
import com.question.common.domain.TreeNode;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:57
 */
@Data
public class MenuEntity extends TreeNode {

    /**
     * 菜单名称
     */
    private String menuName;
    /**
     * 菜单路径
     */
    private String url;
    /**
     * 权限
     */
    private String auth;
    /**
     * 类型
     */
    private String type;
    /**
     * 所属系统
     */
    private String system;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 图标
     */
    private String iconClass;

}
