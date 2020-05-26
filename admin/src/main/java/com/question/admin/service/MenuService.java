package com.question.admin.service;

import com.question.admin.model.req.MenuSaveReq;
import com.question.admin.model.view.MenuView;
import com.question.admin.model.view.UserView;
import com.question.common.response.ResponseJson;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/17 23:19
 */
public interface MenuService {
    List<MenuView> listMenu();

    List<MenuView> menuTree() throws Exception;

    ResponseJson saveMenu(MenuSaveReq menuSaveReq);

    ResponseJson editMenu(MenuSaveReq menuSaveReq);
}
