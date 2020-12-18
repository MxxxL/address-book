package com.kaiyu;

import com.kaiyu.entity.User;
import com.kaiyu.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

@SpringBootTest
class WechatMiniProgramDesignApplicationTests {

    @Autowired
    IUserService userService;

    @Test
    void contextLoads() {
        User user = userService.selectUser("test",DigestUtils.md5DigestAsHex("123456".getBytes()));

        System.out.println(user);
    }

}
