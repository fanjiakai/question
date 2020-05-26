package com.question.admin.model.view;

import com.question.common.domain.TreeNode;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 23:33
 */
@Data
public class MenuView extends TreeNode {

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
     * 所属系统
     */
    private String system;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序
     */
    private String orderNum;
    /**
     * 图标
     */
    private String iconClass;
}
