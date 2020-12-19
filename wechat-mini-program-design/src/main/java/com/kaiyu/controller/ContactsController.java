package com.kaiyu.controller;

import com.alibaba.fastjson.JSON;
import com.kaiyu.entity.Contacts;
import com.kaiyu.service.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 联系人控制层
 * @author ：mxxxl
 * @date ：2020/12/19
 */
@Controller
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    IContactsService contactsService;

    @RequestMapping("/list")
    @ResponseBody
    public Object getContactsList(){
        Map<Object,Object> map = new HashMap<>(16);
        List<Contacts> contacts = contactsService.selectAllContacts();
        map.put("msg","获取所有联系人信息");
        map.put("code",200);
        map.put("contacts",contacts);
        return map;
    }
}
