package com.question.admin.interceptor;

import com.question.admin.common.BoundSqlSource;
import com.question.admin.annotation.DataSourceInterceptor;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author: FanJiaKai
 * @Description: mybatis拦截器  增加数据权限
 * @Date: Created in 2019/12/12 22:59
 */
@Component
@Intercepts({@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class MyMybatisInterceptor implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        if (invocation.getTarget() instanceof Executor && invocation.getArgs().length==4) {
            final Object[] args = invocation.getArgs();
            MappedStatement ms = (MappedStatement) args[0];
            try {
                String className = ms.getId();
                Class<?> clazz = Class.forName(className.substring(0,className.indexOf("Mapper") + 6));
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if(className.indexOf(method.getName()) != -1 && method.getAnnotation( DataSourceInterceptor.class) != null){
                        String sql = getSqlByInvocation(invocation);
                        //将操作员可操作的渠道、用户id及营业部作通用字段放到sql中统一解析
                        if(sql.contains("sys_user")){
                            sql = addPremissionParam(sql);
                            resetSql2Invocation(invocation, sql);
                        }
                    }
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object o) {
        System.out.println(o);
        return Plugin.wrap(o, this);
    }

    @Override
    public void setProperties(Properties properties) {
        System.out.println(properties);
        String p = properties.getProperty("property");
    }

    /**
     * 通用权限字段添加，目前支持：commonEnShortCode、commonEnBrokerUserId、commonEnBranchNo
     * @param sql
     * @return
     */
    private String addPremissionParam(String sql) {
        /*CrhUser crhUser = (CrhUser) RequestUtil.getRequest().getAttribute(CrhUser.CRH_USER_SESSION);
        BackendRoleServiceImpl backendRoleService = (BackendRoleServiceImpl)SpringContext.getBean("backendRoleServiceImpl");
        if(sql.contains("commonEnBranchNo")){
            List<String> enBranchNoList = backendRoleService.getEnBranchNo(crhUser.getUser_id());
            String enBranchNoSql = "select to_char(column_value) from TABLE(SELECT F_TO_T_IN('"+ StringUtils.join(enBranchNoList,",")+"') FROM DUAL)";
            sql = sql.replace("${commonEnBranchNo}", enBranchNoSql);
        }*/
//        sql = sql + " where id = 1";
        return sql;
    }

    /**
     * 获取当前sql
     * @param invocation
     * @return
     */
    private String getSqlByInvocation(Invocation invocation) {
        final Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];

        Object parameterObject = args[1];
        BoundSql boundSql = ms.getBoundSql(parameterObject);
        return boundSql.getSql();
    }

    /**
     * 将sql重新设置到invocation中
     * @param invocation
     * @param sql
     * @throws SQLException
     */
    private void resetSql2Invocation(Invocation invocation, String sql) throws SQLException {
        final Object[] args = invocation.getArgs();
        MappedStatement statement = (MappedStatement) args[0];
        Object parameterObject = args[1];
        BoundSql boundSql = statement.getBoundSql(parameterObject);
        MappedStatement newStatement = newMappedStatement(statement, new BoundSqlSource(boundSql) );
        MetaObject msObject =  MetaObject.forObject(newStatement, new DefaultObjectFactory(), new DefaultObjectWrapperFactory(),new DefaultReflectorFactory());
        msObject.setValue("sqlSource.boundSql.sql", sql);
        args[0] = newStatement;
    }

    private MappedStatement newMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder =
                new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());
        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        if (ms.getKeyProperties() != null && ms.getKeyProperties().length != 0) {
            StringBuilder keyProperties = new StringBuilder();
            for (String keyProperty : ms.getKeyProperties()) {
                keyProperties.append(keyProperty).append(",");
            }
            keyProperties.delete(keyProperties.length() - 1, keyProperties.length());
            builder.keyProperty(keyProperties.toString());
        }
        builder.timeout(ms.getTimeout());
        builder.parameterMap(ms.getParameterMap());
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }
}
