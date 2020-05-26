package com.question.admin.model.entity;

import com.question.common.domain.BaseEntity;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:30
 */
@Data
public class DictEntity extends BaseEntity {

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
