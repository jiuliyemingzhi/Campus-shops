package com.jiuli.campusshops.dao;


import com.jiuli.campusshops.BaseTest;
import com.jiuli.campusshops.entity.Area;
import com.jiuli.campusshops.entity.Shop;
import com.jiuli.campusshops.entity.ShopCategory;
import com.jiuli.campusshops.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class ShopDaoTest extends BaseTest {
    @Autowired
    private ShopDao shopDao;


    @Test
    public void testInsertShop() {
        Shop shop = new Shop();
        User owner = new User();
        Area area = new Area();
        ShopCategory category = new ShopCategory();
        owner.setId(1);
        area.setId(2);
        category.setId(1);
        shop.setUserOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(category);
        shop.setName("testName");
        shop.setShopDesc("testDesc");
        shop.setTelNumber("1234556677");
        shop.setAddress("test");
        shop.setImage("image");
        shop.setPriority(1);
        shop.setStatus(1);
        shop.setAdvice("审核中!");
        int effected = shopDao.insertShop(shop);
        assertEquals(1, effected);
    }

    @Test
    public void testUpdateShop() {
        Shop shop = new Shop();
        User owner = new User();
        Area area = new Area();
        ShopCategory category = new ShopCategory();
        owner.setId(1);
        area.setId(2);
        category.setId(1);
        shop.setId(1);
        shop.setUserOwner(owner);
        shop.setArea(area);
        shop.setShopCategory(category);
        shop.setName("testName1");
        shop.setShopDesc("testDesc1");
        shop.setTelNumber("1234556677");
        shop.setAddress("test-iiiii-描述");
        shop.setImage("image");
        shop.setPriority(2);
        shop.setStatus(1);
        shop.setAdvice("审核--!");
        int effected = shopDao.updateShop(shop);
        assertEquals(1, effected);
    }
}
