package com.question.admin.dao.dao_01;

import com.github.pagehelper.Page;
import com.question.admin.model.entity.UserEntity;
import com.question.admin.model.req.UserReq;
import com.question.admin.annotation.DataSourceInterceptor;
import com.question.admin.model.req.UserSaveReq;
import com.question.common.annotation.PageStart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/10 22:56
 */
@Mapper
public interface UserMapper {

    @DataSourceInterceptor(methodName = "selectAll")
    List<UserEntity> selectAll();

    @PageStart(clazz = UserReq.class)
    @DataSourceInterceptor(methodName = "selectPage")
    Page<UserEntity> selectPage(UserReq userReq);

    void insertUser(UserSaveReq userSaveReq);

    @DataSourceInterceptor(methodName = "getUserById")
    UserEntity getUserById(UserReq userReq);
}
