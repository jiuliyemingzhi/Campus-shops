package com.jiuli.campusshops.enums;

public enum ShopStateEnum {

    CHECK(1, "审核中"),

    OFFLINE(-1, "非法店铺"),

    SUCCESS(2, "操作成功"),

    PASS(3, "通过认证"),

    INNER_ERROR(-1001, "内部系统错误"),

    BAD_SHOP_RESP(-1002, "shop信息错误"),

    NULL_SHOP(-1003, "shop信息为空");

    private int state;

    private String stateInfo;


    ShopStateEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public static ShopStateEnum stateOf(int state) {
        for (ShopStateEnum stateEnum : values()) {
            if (stateEnum.state == state) {
                return stateEnum;
            }
        }
        return null;
    }

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }


}
