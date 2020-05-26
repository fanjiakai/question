package com.question.admin.service.impl;

import com.question.admin.dao.dao_01.MenuMapper;
import com.question.admin.model.entity.MenuEntity;
import com.question.admin.model.req.MenuSaveReq;
import com.question.admin.model.view.MenuView;
import com.question.admin.service.MenuService;
import com.question.common.response.ResponseJson;
import com.question.common.utils.BeanUtilsBean2TryCatch;
import com.question.common.utils.TreeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/17 23:19
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuView> listMenu() {
        List<MenuEntity> list = menuMapper.selectAll();
        List<MenuView> userViews = new BeanUtilsBean2TryCatch<MenuEntity,MenuView>().copyPropertiesList(list, MenuView.class);
        return userViews;
    }

    @Override
    public List<MenuView> menuTree() throws Exception{
        List<MenuView> menuViews = new TreeUtil<>(this.listMenu()).builTree();
        return menuViews;
    }

    @Override
    public ResponseJson saveMenu(MenuSaveReq menuSaveReq) {
        menuMapper.insertMenu(menuSaveReq);
        return ResponseJson.newResponseJson();
    }

    @Override
    public ResponseJson editMenu(MenuSaveReq menuSaveReq) {
        menuMapper.updateMenu(menuSaveReq);
        return ResponseJson.newResponseJson();
    }
}
