package com.question.admin.model.view;

import com.question.common.domain.BaseView;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:29
 */
@Data
public class DictView extends BaseView {

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
