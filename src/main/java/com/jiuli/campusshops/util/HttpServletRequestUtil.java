package com.jiuli.campusshops.util;

import javax.servlet.http.HttpServletRequest;
import java.net.HttpRetryException;

public class HttpServletRequestUtil {
    public static int getInt(HttpServletRequest request, String key) {
        try {
            return Integer.decode(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static long getLong(HttpServletRequest request, String key) {
        try {
            return Long.decode(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double getDouble(HttpServletRequest request, String key) {
        try {
            return Double.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static boolean getBoolean(HttpServletRequest request, String key) {
        try {
            return Boolean.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static byte getByte(HttpServletRequest request, String key) {
        try {
            return Byte.valueOf(request.getParameter(key));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static String getString(HttpServletRequest request, String key) {
        try {
            String result = request.getParameter(key);
            if (!Util.stringIsEmpty(result)) {
                result = result.trim();
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

}
