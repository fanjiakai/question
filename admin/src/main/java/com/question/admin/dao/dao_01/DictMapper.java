package com.question.admin.dao.dao_01;

import com.github.pagehelper.Page;
import com.question.admin.model.req.DictReq;
import com.question.common.annotation.PageStart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/21 9:17
 */
@Mapper
@Repository
public interface DictMapper {

    @PageStart(clazz = DictReq.class)
    Page selectPage(DictReq dictReq);
}
