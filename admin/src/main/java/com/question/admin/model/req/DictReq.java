package com.question.admin.model.req;

import com.question.common.domain.BaseReq;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:21
 */
@Data
public class DictReq extends BaseReq {

    /**
     * 字典标签
     */
    private String category;
    /**
     * 字典键值
     */
    private String key;
    /**
     * 字典值
     */
    private String value;
    /**
     * 标签名
     */
    private String name;
    /**
     * 类型
     */
    private String type;
    /**
     * 排序
     */
    private String orderNum;
}
