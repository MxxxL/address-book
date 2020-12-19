package com.kaiyu.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 联系人实体类
 * @author ：mxxxl
 * @date ：2020/12/19
 */
public class Contacts implements Serializable {

    private static final long serialVersionUID = -4236034548833772088L;

    private Integer id;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Contacts() {
    }

    public Contacts(String name, String phone, String email, String address) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contacts contacts = (Contacts) o;
        return Objects.equals(id, contacts.id) &&
                Objects.equals(name, contacts.name) &&
                Objects.equals(phone, contacts.phone) &&
                Objects.equals(email, contacts.email) &&
                Objects.equals(address, contacts.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, email, address);
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
