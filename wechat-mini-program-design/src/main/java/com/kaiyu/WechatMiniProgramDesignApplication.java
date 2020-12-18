package com.kaiyu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.kaiyu.dao")
@SpringBootApplication
public class WechatMiniProgramDesignApplication {

    public static void main(String[] args) {
        SpringApplication.run(WechatMiniProgramDesignApplication.class, args);
    }

}
