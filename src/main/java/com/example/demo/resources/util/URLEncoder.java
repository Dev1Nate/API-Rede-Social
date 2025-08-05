package com.example.demo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URLEncoder {
    public static String decodeParameter(String msg){
        try {
            return URLDecoder.decode(msg,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
