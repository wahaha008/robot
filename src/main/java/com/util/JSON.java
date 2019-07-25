package com.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JSON {

    public static Gson gson = new Gson();
    public static Gson _gson = new Gson();

    public JSON() {
    }

    public static <T> T fromJson(String json, Type type) {
        return gson.fromJson(json, type);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    public static String toPrettyJson(Object obj) {
        return _gson.toJson(obj);
    }
}
