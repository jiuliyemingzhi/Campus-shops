package com.jiuli.campusshops.util;

import java.io.File;

public class PathUtil {
    private static final ClassLoader classLoader = PathUtil.class.getClassLoader();

    public static String getImageBasePath() {
        String os = System.getProperty("os.name");
        String basePath;
        if (os.toLowerCase().startsWith("win")) {
            basePath = "C:/Users/jiuli/warehouse/image";
        } else {
            basePath = "/home/workspace/image";
        }
        basePath = basePath.replace("/", File.separator);
        return basePath;
    }

    public static String getSourcePath(String name) {
        return classLoader.getResource(name).getPath();
    }

    public static String getShopImagePath(Integer shopId) {
        String imagePath = "/upload/item/shop/" + shopId + "/";
        return imagePath.replace("/", File.separator);
    }

}
