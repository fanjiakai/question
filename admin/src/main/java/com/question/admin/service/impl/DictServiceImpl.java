package com.question.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.dao.dao_01.DictMapper;
import com.question.admin.model.entity.DictEntity;
import com.question.admin.model.req.DictReq;
import com.question.admin.model.view.DictView;
import com.question.admin.service.DictService;
import com.question.common.response.ResponseJson;
import com.question.common.utils.BeanUtilsBean2TryCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/20 11:32
 */
@Service
public class DictServiceImpl implements DictService {

    @Autowired
    private DictMapper dictMapper;

    @Override
    public PageInfo listDict(DictReq dictReq) {
        Page page = dictMapper.selectPage(dictReq);
        PageInfo pageInfo = new PageInfo(page);
        pageInfo.setList(new BeanUtilsBean2TryCatch<DictEntity,DictView>().copyPropertiesList(page.getResult(), DictView.class));
        return pageInfo;
    }
}
