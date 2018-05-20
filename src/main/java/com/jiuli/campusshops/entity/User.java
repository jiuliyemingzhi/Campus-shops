package com.jiuli.campusshops.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class User {
    //顾客
    public static final int TYPE_CUSTOMER = 0;
    //店铺管理员
    public static final int TYPE_SHOP_MANAGER = 1;
    //超级管理员
    public static final int TYPE_SUPER_MANAGER = 2;

    private Integer id;
    private String name;
    private String portrait;
    private String email;
    private String sex;
    private String telNumber;
    private Integer enable;
    private Integer type;
    private long createAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private long updateAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

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

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
