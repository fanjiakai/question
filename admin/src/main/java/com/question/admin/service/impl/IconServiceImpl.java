package com.question.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.dao.dao_01.IconMapper;
import com.question.admin.model.entity.IconEntity;
import com.question.admin.model.entity.MenuEntity;
import com.question.admin.model.req.IconReq;
import com.question.admin.model.req.IconSaveReq;
import com.question.admin.model.view.IconView;
import com.question.admin.service.IconService;
import com.question.common.response.ResponseJson;
import com.question.common.utils.BeanUtilsBean2TryCatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/24 10:18
 */
@Service
public class IconServiceImpl implements IconService {

    @Autowired
    private IconMapper iconMapper;


    @Override
    public List<IconView> listIcon(IconReq iconReq) {
        List<MenuEntity> list = iconMapper.selectAll(iconReq);
        List<IconView> iconViews = new BeanUtilsBean2TryCatch<MenuEntity,IconView>().copyPropertiesList(list, IconView.class);
        return iconViews;
    }

    @Override
    public ResponseJson synchIcon(List<IconSaveReq> icons) {
        iconMapper.insertIcons(icons);
        return ResponseJson.newResponseJson();
    }

    @Override
    public PageInfo pageList(IconReq iconReq) {
        Page page = iconMapper.selectPage(iconReq);
        PageInfo pageInfo = new PageInfo(page);
        pageInfo.setList(new BeanUtilsBean2TryCatch<IconEntity,IconView>().copyPropertiesList(pageInfo.getList(),IconView.class));
        return pageInfo;
    }
}
