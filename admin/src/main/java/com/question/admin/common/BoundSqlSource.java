package com.question.admin.common;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.SqlSource;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/13 1:18
 */
public class BoundSqlSource implements SqlSource {

    private BoundSql boundSql;

    public BoundSqlSource(BoundSql boundSql) {
        this.boundSql = boundSql;
    }

    @Override
    public BoundSql getBoundSql(Object parameterObject) {
        return boundSql;
    }
}