package com.jiuli.campusshops.service;

import com.jiuli.campusshops.dto.ShopExecution;
import com.jiuli.campusshops.entity.Shop;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.InputStream;

public interface ShopService {
    ShopExecution addShop(Shop shop, CommonsMultipartFile shopImg);
//    ShopExecution addShop(Shop shop, InputStream inputStream, String extension)
}
