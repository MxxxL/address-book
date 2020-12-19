package com.kaiyu.service;

import com.kaiyu.entity.Contacts;

import java.util.List;

/**
 * 联系人业务层
 * @author ：44356
 * @date ：2020/12/19
 */
public interface IContactsService {

    /**
     * 查询所有联系人
     * @return 联系人list
     */
    List<Contacts> selectAllContacts();

    /**
     * 根据id查询联系人
     * @param id 联系人id
     * @return 联系人
     */
    Contacts selectById(Integer id);

    /**
     * 新增联系人
     * @param contacts 待新增的联系人
     * @return 新增结果
     */
    int saveContacts(Contacts contacts);

    /**
     * 编辑联系人
     * @param contacts 待编辑的联系人
     * @return 编辑结果
     */
    int editContacts(Contacts contacts);

    /**
     * 根据id删除联系人
     * @param id 联系人id
     * @return 删除结果
     */
    int deleteContactsById(Integer id);
}
