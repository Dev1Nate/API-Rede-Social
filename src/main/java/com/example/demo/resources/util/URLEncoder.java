package com.example.demo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class URLEncoder {
    public static String decodeParameter(String msg){
        try {
            return URLDecoder.decode(msg,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static LocalDate dateConverted(String textDate,LocalDate reserveDate){
        DateTimeFormatter form = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            return LocalDate.parse(textDate,form);
        }catch (RuntimeException e){
            e.printStackTrace();
            return reserveDate;
        }
    }
}
