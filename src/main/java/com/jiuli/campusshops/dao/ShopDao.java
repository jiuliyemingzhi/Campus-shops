package com.jiuli.campusshops.dao;

import com.jiuli.campusshops.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺 1成功 -1失败
     *
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 更新店铺信息 1成功 -1失败
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
}
