package com.question.admin.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.question.admin.model.entity.UserEntity;
import com.question.admin.model.req.UserReq;
import com.question.admin.model.req.UserSaveReq;
import com.question.admin.model.view.UserView;
import com.question.common.response.ResponseJson;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:56
 */
//public interface UserService extends IService<UserEntity> {
public interface UserService{
    List<UserView> getAll();

    PageInfo pageList(UserReq userReq);

    ResponseJson save(UserSaveReq userSaveReq);

    UserView getUserById(UserReq userReq);
}
