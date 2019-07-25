package com.conf;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

public class Config {

    public static String getValue(String key) {
        ResourceBundle bundle = ResourceBundle.getBundle("conf/cnm");
        String valueCN = null;
        try {
            valueCN = new String(bundle.getString(key).getBytes("ISO-8859-1"), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return valueCN;
    }

    public static String getFile(String  path) {
        ResourceBundle bundle = ResourceBundle.getBundle("conf/robot");
        String valueCN = null;
        try {
            valueCN = new String(bundle.getString(path).getBytes("ISO-8859-1"), "UTF8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return valueCN;
    }
}
