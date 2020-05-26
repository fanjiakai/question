package com.question.admin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.question.admin.dao.dao_01.UserMapper;
import com.question.admin.domain.UserDomain;
import com.question.admin.model.entity.UserEntity;
import com.question.admin.model.req.UserReq;
import com.question.admin.model.req.UserSaveReq;
import com.question.admin.model.view.UserView;
import com.question.admin.service.UserService;
import com.question.common.response.ResponseJson;
import com.question.common.utils.BeanUtilsBean2TryCatch;
import com.question.common.utils.SmartContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.Executor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Wrapper;
import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:56
 */
@Service
@Slf4j
//public class UserServiceImpl extends ServiceImpl<UserMapper,UserEntity> implements UserService {
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserView> getAll() {
        List<UserEntity> list = userMapper.selectAll();
        List<UserView> userViews = new BeanUtilsBean2TryCatch<UserEntity,UserView>().copyPropertiesList(list, UserView.class);
        return userViews;
    }

    @Override
    public PageInfo pageList(UserReq userReq) {
        Page page = userMapper.selectPage(userReq);
        PageInfo pageInfo = new PageInfo(page);
        pageInfo.setList(new BeanUtilsBean2TryCatch<UserEntity,UserView>().copyPropertiesList(page.getResult(), UserView.class));
        return pageInfo;
    }

    @Override
    public ResponseJson save(UserSaveReq userSaveReq) {
        userMapper.insertUser(userSaveReq);
        return ResponseJson.newResponseJson();
    }

    @Override
    public UserView getUserById(UserReq userReq) {
        UserEntity userEntity = userMapper.getUserById(userReq);
        UserView userView = BeanUtilsBean2TryCatch.copyProperties(userEntity, UserView.class);
        return userView;
    }
}
