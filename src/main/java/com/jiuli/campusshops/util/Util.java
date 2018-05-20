package com.jiuli.campusshops.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jiuli.campusshops.base.PushModel;

import java.time.LocalDateTime;
import java.util.List;

public class Util {
    private static  Gson gson;


    /**
     * ȡ��һ��ȫ�ֵ�Gson
     *
     * @return Gson
     */
    public static Gson getGson() {
        if (gson == null) {
            GsonBuilder builder = new GsonBuilder()
                    // ���л�Ϊnull���ֶ�
                    .serializeNulls()
                    // �����������@Exposeע��ı���
//                    .excludeFieldsWithoutExposeAnnotation()
                    // ֧��Map
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
