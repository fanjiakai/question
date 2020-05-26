package com.question.admin.dao.dao_01;

import com.question.admin.annotation.DataSourceInterceptor;
import com.question.admin.model.entity.MenuEntity;
import com.question.admin.model.req.MenuSaveReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/17 23:22
 */
@Mapper
@Repository
public interface MenuMapper {

//    @DataSourceInterceptor(methodName = "selectAll")
    List<MenuEntity> selectAll();

    void insertMenu(MenuSaveReq menuSaveReq);

    void updateMenu(MenuSaveReq menuSaveReq);
}
