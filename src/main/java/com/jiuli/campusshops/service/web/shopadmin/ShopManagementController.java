package com.jiuli.campusshops.service.web.shopadmin;

import com.google.gson.JsonSyntaxException;
import com.jiuli.campusshops.base.ResponseModel;
import com.jiuli.campusshops.card.ShopCard;
import com.jiuli.campusshops.dao.ShopDao;
import com.jiuli.campusshops.dto.ShopExecution;
import com.jiuli.campusshops.entity.Area;
import com.jiuli.campusshops.entity.Shop;
import com.jiuli.campusshops.entity.User;
import com.jiuli.campusshops.enums.ShopStateEnum;
import com.jiuli.campusshops.exception.ShopOperationException;
import com.jiuli.campusshops.service.ShopService;
import com.jiuli.campusshops.util.HttpServletRequestUtil;
import com.jiuli.campusshops.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
@Controller
@RequestMapping("/shopadmin")
public class ShopManagementController {

    @Autowired
    private ShopService shopService;

    @ResponseBody
    @RequestMapping(value = "/registershop", method = RequestMethod.POST)
    private Map<String, Object> registerShop(HttpServletRequest request) {
        HashMap<String, Object> modelMap = new HashMap<>();
        //接收并转换相应的参数,包括店铺在内的图片信息
        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        Shop shop;
        try {
            shop = Util.getGson().fromJson(shopStr, Shop.class);
        } catch (JsonSyntaxException e) {
            modelMap.put("success", false);
            modelMap.put("error", e.getMessage());
            return modelMap;
        }
        CommonsMultipartFile image = null;
        CommonsMultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (resolver.isMultipart(request)) {
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
            image = (CommonsMultipartFile) multipartHttpServletRequest.getFile("image");
        } else {
            modelMap.put("success", false);
            modelMap.put("error", "图片不能为空!");
            return modelMap;
        }
        //注册店铺
        if (shop == null || image == null) {
            modelMap.put("success", false);
            modelMap.put("error", "请检查店铺信息!");
        }
        //TODO
        User owner = new User();
        owner.setId(1);
        shop.setUserOwner(owner);
        ShopExecution se = shopService.addShop(shop, image);
        //返回结果
        if (se != null && se.getState() == ShopStateEnum.CHECK.getState()) {
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("error: ", se.getStateInfo());
        }

        return modelMap;
    }


    @Autowired
    private ShopDao shopDao;

    @Transactional
    @ResponseBody
    @RequestMapping(value = "/registershop", method = RequestMethod.PUT)
    public ResponseModel<ShopCard> registerShop(@RequestBody() Shop shop) {
        //接收并转换相应的参数,包括店铺在内的图片信息
        Area area = new Area();
        area.setId(1);
        shop.setArea(area);
        User owner = new User();
        owner.setId(1);
        shop.setUserOwner(owner);
        if (!Shop.check(shop)) {
            return ResponseModel.buildParameterError();
        }

        //TODO
        shop.setStatus(Shop.STATUS_CHECK);
        int state = 0;
        try {
            state = shopDao.insertShop(shop);
        } catch (ShopOperationException e) {
            throw new ShopOperationException("插入失败.");
        }
        if (state != 1) {
            return ResponseModel.buildServiceError();
        }
        return ResponseModel.buildOk(new ShopCard(shop));
    }
}
