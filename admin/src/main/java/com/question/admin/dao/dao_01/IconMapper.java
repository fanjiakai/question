package com.question.admin.dao.dao_01;

import com.github.pagehelper.Page;
import com.question.admin.model.entity.IconEntity;
import com.question.admin.model.entity.MenuEntity;
import com.question.admin.model.req.IconReq;
import com.question.admin.model.req.IconSaveReq;
import com.question.common.annotation.PageStart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/24 10:19
 */
@Mapper
@Repository
public interface IconMapper {

    List<MenuEntity> selectAll(IconReq iconReq);

    void insertIcons(@Param("icons") List<IconSaveReq> icons);

    @PageStart(clazz = IconReq.class)
    Page selectPage(IconReq iconReq);
}
