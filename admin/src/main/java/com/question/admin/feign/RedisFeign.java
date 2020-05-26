package com.question.admin.feign;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author: FanJiaKai
 * @Description:
 * @Date: Created in 2019/12/30 23:40
 */
@FeignClient(value = "api-redis")
public interface RedisFeign {
}
