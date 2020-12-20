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

import java.util.HashMap;
import java.util.Map;

/**
 * 登录，注册控制器
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
    public Object doLogin(@RequestParam("username")String username,
                          @RequestParam("password")String password){
        Map<Object,Object> map = new HashMap<>(16);
        String codePassword = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = userService.selectUser(username, codePassword);

        if (user!=null){
            map.put("msg","登录成功");
            map.put("code",200);
        }else {
            map.put("msg","登录失败");
            map.put("code",400);
        }

        return map;
    }

    @RequestMapping("register")
    @ResponseBody
    public Object doRegister(@RequestParam("username")String username,
                              @RequestParam("password")String password){
        Map<Object,Object> map = new HashMap<>(16);
        String codePassword = DigestUtils.md5DigestAsHex(password.getBytes());
        User user = new User(username,codePassword);
        int result = userService.saveUser(user);
        if (result>0){
            map.put("msg","注册成功");
            map.put("code",200);
        }else {
            map.put("msg","注册失败，数据异常");
            map.put("code",400);
        }
        return map;
    }
}
