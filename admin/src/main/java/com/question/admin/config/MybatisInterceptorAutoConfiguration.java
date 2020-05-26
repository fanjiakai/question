package com.question.admin.config;

import com.github.pagehelper.PageInterceptor;
import com.question.admin.interceptor.MyMybatisInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Properties;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/13 0:24
 */
@Configuration
public class MybatisInterceptorAutoConfiguration {

    @Autowired
    private List<SqlSessionFactory> sqlSessionFactoryList;

    @Bean
    @ConfigurationProperties(prefix = "pagehelper")
    public Properties pageHelperProperties() {
        return new Properties();
    }

    @PostConstruct
    public void addMysqlInterceptor() {
        //数据权限拦截器
        MyMybatisInterceptor dataPermissionInterceptor = new MyMybatisInterceptor();
        //分页拦截器
        PageInterceptor pageInterceptor = new PageInterceptor();
        pageInterceptor.setProperties(this.pageHelperProperties());
        for (SqlSessionFactory sqlSessionFactory : sqlSessionFactoryList) {
            sqlSessionFactory.getConfiguration().addInterceptor(pageInterceptor);
            sqlSessionFactory.getConfiguration().addInterceptor(dataPermissionInterceptor);
        }
    }

}
