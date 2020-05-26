package com.question.admin.model.req;

import com.question.common.domain.BaseReq;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 23:33
 */
@Data
public class MenuSaveReq extends BaseReq {

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
