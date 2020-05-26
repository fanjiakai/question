package com.question.admin.model.req;

import com.question.common.domain.BaseReq;
import lombok.Data;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/24 10:16
 */
@Data
public class IconReq extends BaseReq {

    /**
     * 图标class类
     */
    private String iconClass;
    /**
     * 图标名
     */
    private String name;
    /**
     * 图标文件
     */
    private String iconFiles;
    /**
     * 分类
     */
    private String classify;

}
