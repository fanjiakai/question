package com.question.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2020/1/13 10:02
 */

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AxiosCorsFilter extends CorsFilter  {

    public AxiosCorsFilter() {
        super(configurationSource());
    }

    /**
     * 添加跨域
     *
     * @return
     */
    private static UrlBasedCorsConfigurationSource configurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
