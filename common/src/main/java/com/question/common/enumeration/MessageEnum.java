package com.question.common.enumeration;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: FanJiaKai
 * @Description: 返回参数
 * @Date: Created in 2019/12/11 0:29
 */
public enum MessageEnum {

            SUCCESS(0,"操作成功！"),
            FAILED(9999,"操作失败"),

            /** 1000-1999 */
            /** 用户删除 */
            USER_HAS_MENU(1001,"删除失败,用户已分配菜单！"),
            USER_HAS_ROLE(1002,"删除失败,用户已分配角色！"),
            USER_HAS_COMPANY(1003,"删除失败,用户已分配管控单位！"),

            /** 用户修改密码 */
            WRONG_OLD_PWD(1004,"修改密码失败,请输入正确的旧密码!"),

            /**  用户登录 */
            NO_SUCH_USER(1005,"用户不存在!"),
            PASSWORD_WRONG(1006,"密码错误!"),
            USER_LOCKED(1007,"用户已锁定,请联系管理员解锁!"),
            USER_ENABLE(1008,"用户已停用!"),
            OUT_OF_USER_TIME(1009,"登陆日起不在用户有效期"),

            /** 获取权限 */
            CHOOSE_AGAIN(1010, "请重新选择单位!"),
            NO_COMPANY_TO_CHOOSE(1011, "当前用户无所属单位及管控单位,请联系管理员!"),
            /** 校验信息 */
            FIELD_IS_EXIST(1012,"该字段已存在,请重新输入!"),
            TOKEN_OUT_OF_TIME(1013,"token失效!"),
            NET_OUT_OF_TIME(1014,"网络超时,请稍后重试!"),
            NO_ACCESS(1015,"无访问权限!"),

    /**
     * 2000-2999 单位模块返回的业务错误信息
     */
    COMPANY_DELETE_01(2001, "该单位存在过变更，无法删除！"),
    COMPANY_DELETE_02(2002, "该单位存在下级单位，无法删除！"),
    COMPANY_DELETE_03(2003, "该单位存在关联数据，无法删除！"),
    COMPANY_UPDATE_01(2021, "存在营业状态和当前选择状态不相符的下级单位，无法进行修改！"),
    COMPANY_UPDATE_02(2022, "存在营业状态和当前选择状态不相符的上级单位，无法进行修改！"),
    COMPANY_UPDATE_03(2023, "请修改变更生效日期！"),
    // 单位变更,
    COMPANY_CHANGE_01(2031, "该单位无变更记录，无法进行变更！"),
    COMPANY_CHANGE_02(2232, "该数据非最后一条记录无法进行修改！"),

    /** 获取角色列表 */
    BIND_PERMISSION_FAIL(3012,"绑定权限失败"),
    INSERT_ROLE_FAIL(3013,"角色名称重复"),
    UPDATE_ROLE_FAIL(3014,"角色名称重复"),
    TREE_ROLE_TYPE_FAIL(3015,"角色类型错误"),
    UPDATE_EMPTY_FAIL(3016,"角色名称不能有空格"),
    BIND_ROLE_USER_FAIL(3017,"角色互斥"),
    INSERT_ROLE_CODE_FAIL(3018,"该编码已被使用"),
    DELETE_ROLE_FAIL(3019,"角色已被用户授权,是否还要删除角色"),
    BIND_ROLE_FAIL(3020,"权限有断级"),

    FILE_IS_NULL(9998,"文件为空");


    private int code;
    private String message;

    MessageEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    public static Map getMessageMap(MessageEnum msEnum) {
        Map map = new HashMap();
        map.put("msgCode",msEnum.getCode());
        return map;
    }

}
