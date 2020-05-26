package com.question.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: WenheZhu
 * @Description:
 * @Date: Created in 13:382019/7/18
 * @Modified By:
 */
@SpringBootApplication
@EnableEurekaClient
public class RabbitMqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqApplication.class, args);
    }

}
