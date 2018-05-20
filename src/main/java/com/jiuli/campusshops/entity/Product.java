package com.jiuli.campusshops.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class Product {
    public  static  final  int NORMAL_STATUS = 0;
    public  static  final  int SOLD_OUT_STATUS = 1;
    public  static  final  int SELL_OUT_STATUS = 2;

    private Integer id;
    private String name;
    private String productDesc;
    private String imageAddress;
    private String normalPrice;
    private String discountPrice;
    private Integer priority;
    private long createAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private long updateAt = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
    private Integer status;
    private List<ProductImage> productImageList;
    private ProductCategory productCategory;
    private Shop shop;


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

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getNormalPrice() {
        return normalPrice;
    }

    public void setNormalPrice(String normalPrice) {
        this.normalPrice = normalPrice;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<ProductImage> getProductImageList() {
        return productImageList;
    }

    public void setProductImageList(List<ProductImage> productImageList) {
        this.productImageList = productImageList;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
