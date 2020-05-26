package com.question.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.question.common.enumeration.MessageEnum;
import com.question.common.response.ResponseJson;

import javax.servlet.http.HttpServletRequest;

public class AccessFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤逻辑
     * @return 过滤结果
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

//        logger.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());

        Object accessToken = request.getHeader("Authorization");
        if (accessToken==null){
//            logger.warn("Authorization token is empty");
//            requestContext.setSendZuulResponse(false);
//            requestContext.setResponseStatusCode(401);
//            requestContext.setResponseBody("Authorization token is empty");

            return ResponseJson.newErrorJson(MessageEnum.TOKEN_OUT_OF_TIME);
        }
//        logger.info("Authorization token is ok");


        return null;
    }
}
