package com.kaiyu.controller;

import com.kaiyu.entity.User;
import com.kaiyu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author mxxxl
 * @date 2020/12/17
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public boolean doLogin(@RequestParam("username")String username,
                          @RequestParam("password")String password){
        String codePassword = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userService.selectUser(username, codePassword);
        System.out.println(user);
        return user != null;
    }

    @RequestMapping("register")
    @ResponseBody
    public boolean doRegister(@RequestParam("username")String username,
                              @RequestParam("password")String password){
        String codePassword = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = new User(username,codePassword);
        int result = userService.saveUser(user);
        return result > 0;
    }
}
