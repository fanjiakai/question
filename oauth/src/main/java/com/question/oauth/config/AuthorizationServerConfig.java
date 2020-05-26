package com.question.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.concurrent.TimeUnit;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2020/1/9 18:56
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private static final String DEMO_RESOURCE_ID = "order";
    @Autowired
    private AuthenticationManager authenticationManager;

    private static final int ACCESS_TOKEN_VALIDITY_SECONDS = 12 * 60 * 60;
    private static final int FREFRESH_TOKEN_VALIDITY_SECONDS = 30 * 60 * 60;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        System.out.println("================================================================================");
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
        System.out.println("================================================================================");
        // 定义了两个客户端应用的通行证
        clients.inMemory()
                .withClient("admin")
                .secret("{bcrypt}" + new BCryptPasswordEncoder().encode("123456"))
                .resourceIds(DEMO_RESOURCE_ID)
                //authorization_code,refresh_token(针对通过浏览器访问的客户端) ;password,refresh_token"(针对移动设备的客户端)
                .authorizedGrantTypes("authorization_code", "refresh_token","password")
                .scopes("all")
                .and()
                .withClient("sheep2")
                .secret("{bcrypt}" + new BCryptPasswordEncoder().encode("123456"))
                .resourceIds(DEMO_RESOURCE_ID)
                .authorizedGrantTypes("authorization_code", "refresh_token","password")
                .scopes("all");
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                //指定token存储位置
                .tokenStore(jwtTokenStore())
                // 配置JwtAccessToken转换器
                .tokenEnhancer(jwtAccessTokenConverter())
                //指定认证管理器
                .authenticationManager(authenticationManager)
                .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        // 配置tokenServices参数
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(endpoints.getTokenStore());
        // 是否支持刷新
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
        tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
        // 20分钟
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(20));
        endpoints.tokenServices(tokenServices);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    @Bean
    public TokenStore jwtTokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter(){
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("testKey");
        return converter;
    }
}
