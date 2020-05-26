package com.question.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.model.req.DictReq;
import com.question.admin.model.view.DictView;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:32
 */
public interface DictService {
    PageInfo listDict(DictReq dictReq);
}
