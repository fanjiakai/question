package com.question.admin.service;

import com.github.pagehelper.PageInfo;
import com.question.admin.model.req.IconReq;
import com.question.admin.model.req.IconSaveReq;
import com.question.admin.model.view.IconView;
import com.question.common.response.ResponseJson;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/24 10:17
 */
public interface IconService {

    List<IconView> listIcon(IconReq iconReq);

    ResponseJson synchIcon(List<IconSaveReq> icons);

    PageInfo pageList(IconReq iconReq);
}
