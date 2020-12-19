package com.kaiyu.service.impl;

import com.kaiyu.dao.IContactsDao;
import com.kaiyu.entity.Contacts;
import com.kaiyu.service.IContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联系人业务层实现类
 * @author ：mxxxl
 * @date ：2020/12/19
 */
@Service
public class ContactsServiceImpl implements IContactsService {

    @Autowired
    IContactsDao contactsDao;


    @Override
    public List<Contacts> selectAllContacts() {
        return contactsDao.selectAllContacts();
    }

    @Override
    public Contacts selectById(Integer id) {
        return contactsDao.selectById(id);
    }

    @Override
    public int saveContacts(Contacts contacts) {
        return contactsDao.saveContacts(contacts);
    }

    @Override
    public int editContacts(Contacts contacts) {
        return contactsDao.editContacts(contacts);
    }

    @Override
    public int deleteContactsById(Integer id) {
        return contactsDao.deleteContactsById(id);
    }
}
