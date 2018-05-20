package com.jiuli.campusshops.entity;

import com.jiuli.campusshops.util.Util;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class Shop {
    //不可用
    public static final int STATUS_DISABLED = -1;
    //审核中
    public static final int STATUS_CHECK = 0;
    //可用
    public static final int STATUS_ENABLE = 1;

    private Integer id;
    private String name;
    private String shopDesc;
    private String address;
    private String telNumber;
    private String image;
    private Integer priority;
    private long createAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private long updateAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private Integer status;
    private String advice;
    private Area area;
    private User userOwner;
    private ShopCategory shopCategory;

    public static boolean check(Shop shop) {
        return shop != null

                && shop.area != null
                && shop.name != null
                && shop.address != null
                && shop.userOwner != null
                && shop.telNumber != null
                && shop.image != null;
    }

    public static boolean check0(Shop shop) {
        return shop != null
                && shop.area != null
                && shop.name != null
                && shop.address != null
                && shop.userOwner != null
                && shop.telNumber != null;
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

    public long getUpdateAt() {
        return updateAt;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
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

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public User getUserOwner() {
        return userOwner;
    }

    public void setUserOwner(User userOwner) {
        this.userOwner = userOwner;
    }

    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }


    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.setName("13");
        shop.setAddress("hjj");
        shop.setTelNumber("13314457032");
        shop.setShopDesc("sssss");
        shop.setImage("11jfaugjahfiSgasjhgs");
        System.out.println(Util.getGson().toJson(shop));
    }

}
