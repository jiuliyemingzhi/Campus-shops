package com.jiuli.campusshops.service;

import com.jiuli.campusshops.BaseTest;
import com.jiuli.campusshops.entity.Area;
import com.jiuli.campusshops.entity.Shop;
import com.jiuli.campusshops.entity.ShopCategory;
import com.jiuli.campusshops.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ShopServiceTest extends BaseTest {
    @Autowired
    private ShopService shopService;

    @Test
    public void testAddShop() {
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
        shop.setName("testName2");
        shop.setShopDesc("testDesc2");
        shop.setTelNumber("1234556678");
        shop.setAddress("testS");
//        ShopExecution execution = shopService.addShop(shop, ImageUtil.watermark);
//        assertEquals(ShopStateEnum.CHECK.getState(),execution.getState());
    }
}
