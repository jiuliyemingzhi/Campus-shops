package com.jiuli.campusshops.service.impl;

import com.jiuli.campusshops.dao.ShopDao;
import com.jiuli.campusshops.dto.ShopExecution;
import com.jiuli.campusshops.entity.Shop;
import com.jiuli.campusshops.enums.ShopStateEnum;
import com.jiuli.campusshops.exception.ShopOperationException;
import com.jiuli.campusshops.service.ShopService;
import com.jiuli.campusshops.util.ImageUtil;
import com.jiuli.campusshops.util.PathUtil;
import com.jiuli.campusshops.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopDao shopDao;

    @Override
    @Transactional
    public ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        if (!Shop.check0(shop)) {
            return new ShopExecution(ShopStateEnum.BAD_SHOP_RESP);
        }


        try {
            shop.setStatus(Shop.STATUS_CHECK);
            int shopId = shopDao.insertShop(shop);
            if (shopId <= 0) {
                throw new ShopOperationException("µêÆÌ´´½¨Ê§°Ü!");//RuntimeException ÖÕÖ¹Transactional²¢»Ø¹ö
            } else {
                if (shopImg != null) {
                    try {
                        addShopImg(shop, shopImg);
                    } catch (ShopOperationException e) {
                        throw new ShopOperationException("Í¼Æ¬Ìí¼ÓÊ§°Ü!");
                    }
                }
                shopId = shopDao.updateShop(shop);
                if (shopId <= 0) {
                    throw new ShopOperationException("Í¼Æ¬¸üÐÂÊ§°Ü!");
                }
            }
        } catch (ShopOperationException e) {
            throw new ShopOperationException("AddShop Error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }


    //@Override
    @Transactional
    public ShopExecution addShop(Shop shop, InputStream inputStream, String extension) {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP);
        }
        if (!Shop.check0(shop)) {
            return new ShopExecution(ShopStateEnum.BAD_SHOP_RESP);
        }

        try {
            shop.setStatus(Shop.STATUS_CHECK);
            int shopId = shopDao.insertShop(shop);
            if (shopId <= 0) {
                throw new ShopOperationException("µêÆÌ´´½¨Ê§°Ü!");//RuntimeException ÖÕÖ¹Transactional²¢»Ø¹ö
            } else {
                if (inputStream != null && !Util.stringIsEmpty(extension)) {
                    try {
                        addShopImg(shop, inputStream, extension);
                    } catch (ShopOperationException e) {
                        throw new ShopOperationException("Í¼Æ¬Ìí¼ÓÊ§°Ü!");
                    }
                }
                shopId = shopDao.updateShop(shop);
                if (shopId <= 0) {
                    throw new ShopOperationException("Í¼Æ¬¸üÐÂÊ§°Ü!");
                }
            }
        } catch (ShopOperationException e) {
            throw new ShopOperationException("AddShop Error: " + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }


    private void addShopImg(Shop shop, CommonsMultipartFile shopImg) throws ShopOperationException {
        String shopImgPath = PathUtil.getShopImagePath(shop.getId());
        String imagePath = ImageUtil.generateThumbnail(shopImg, shopImgPath);
        shop.setImage(imagePath);
    }

    private void addShopImg(Shop shop, InputStream inputStream, String extension) throws ShopOperationException {
        String shopImgPath = PathUtil.getShopImagePath(shop.getId());
        String imagePath = ImageUtil.generateThumbnail(inputStream, extension, shopImgPath);
        shop.setImage(imagePath);
    }
}
