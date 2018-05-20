package com.jiuli.campusshops.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiuli.campusshops.base.PushModel;

import java.time.LocalDateTime;
import java.util.List;

public class Util {
    private static  Gson gson;


    /**
     * 取得一个全局的Gson
     *
     * @return Gson
     */
    public static Gson getGson() {
        if (gson == null) {
            GsonBuilder builder = new GsonBuilder()
                    // 序列化为null的字段
                    .serializeNulls()
                    // 仅仅处理带有@Expose注解的变量
//                    .excludeFieldsWithoutExposeAnnotation()
                    // 支持Map
                    .enableComplexMapKeySerialization();

            gson = builder.create();
        }
        return gson;
    }


    public static boolean stringIsEmpty(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static String toJson(List<PushModel.Entity> entities) {
        return getGson().toJson(entities);
    }
}
