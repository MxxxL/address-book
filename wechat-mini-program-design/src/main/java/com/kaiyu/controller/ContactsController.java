package com.kaiyu.controller;

import com.kaiyu.entity.Contacts;
import com.kaiyu.service.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
        if (!contacts.isEmpty()){
            map.put("msg","获取所有联系人信息成功");
            map.put("code",200);
            map.put("contacts",contacts);
        }else {
            map.put("msg","获取所有联系人信息失败");
            map.put("code",500);
            map.put("contacts",contacts);
        }

        return map;
    }

    @GetMapping("/select")
    @ResponseBody
    public Object selectContactsById(@RequestParam("id")Integer id){
        Map<Object,Object> map = new HashMap<>(16);
        Contacts contacts = contactsService.selectById(id);
        if (contacts!=null){
            map.put("msg","根据id查询联系人成功");
            map.put("code",200);
            map.put("contacts",contacts);
        }else {
            map.put("msg","根据id查询联系人失败");
            map.put("code",500);
            map.put("contacts",contacts);
        }

        return map;
    }


    @PostMapping("/save")
    @ResponseBody
    public Object saveContacts(@RequestParam("name")String name,
                               @RequestParam("phone")String phone,
                               @RequestParam("email")String email,
                               @RequestParam("address")String address){
        Map<Object,Object> map = new HashMap<>(16);
        Contacts contacts = new Contacts(name,phone,email,address);
        int result = contactsService.saveContacts(contacts);
        if (result>0){
            map.put("msg","ok");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @PostMapping("/edit")
    @ResponseBody
    public Object editContacts(@RequestParam("id")Integer id,
                               @RequestParam("name")String name,
                               @RequestParam("phone")String phone,
                               @RequestParam("email")String email,
                               @RequestParam("address")String address){
        Map<Object,Object> map = new HashMap<>(16);
        Contacts contacts = new Contacts(name,phone,email,address);
        contacts.setId(id);
        int result = contactsService.editContacts(contacts);
        if (result>0){
            map.put("msg","ok");
        }else {
            map.put("msg","fail");
        }
        return map;
    }

    @GetMapping("/delete")
    @ResponseBody
    public Object deleteContacts(@RequestParam("id")Integer id){
        Map<Object,Object> map = new HashMap<>(16);
        int result = contactsService.deleteContactsById(id);
        if (result>0){
            map.put("msg","ok");
        }else {
            map.put("msg","fail");
        }
        return map;
    }
}
