package com.jiuli.campusshops.card;

import com.jiuli.campusshops.entity.Shop;

import java.time.LocalDateTime;

public class ShopCard {
    private Integer id;
    private String name;
    private String shopDesc;
    private String address;
    private String telNumber;
    private String image;
    private Integer priority;
    private long createAt;
    private long updateAt;
    private Integer status;
    private String advice;
    private Integer areaID;
    private Integer userOwnerID;
    private Integer shopCategoryID;

    public ShopCard(Shop shop) {
        this.id = shop.getId();
        this.name = shop.getName();
        this.shopDesc = shop.getShopDesc();
        this.address = shop.getAddress();
        this.telNumber = shop.getTelNumber();
        this.image = shop.getImage();
        this.priority = shop.getPriority();
        this.createAt = shop.getCreateAt();
        this.updateAt = shop.getUpdateAt();
        this.status = shop.getStatus();
        this.advice = shop.getAdvice();
        if (shop.getArea() != null) {
            this.areaID = shop.getArea().getId();
        }
        if (shop.getUserOwner() != null) {
            this.userOwnerID = shop.getUserOwner().getId();
        }
        if (shop.getShopCategory() != null) {
            this.shopCategoryID = shop.getShopCategory().getId();
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserOwnerID(Integer userOwnerID) {
        this.userOwnerID = userOwnerID;
    }

    public void setShopCategoryID(Integer shopCategoryID) {
        this.shopCategoryID = shopCategoryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShopDesc() {
        return shopDesc;
    }

    public void setShopDesc(String shopDesc) {
        this.shopDesc = shopDesc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    public long getCreateAt() {
        return createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice;
    }

    public Integer getAreaID() {
        return areaID;
    }

    public void setAreaID(Integer areaID) {
        this.areaID = areaID;
    }

}
