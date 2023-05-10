package com.digivisions.assessment.utils;

public class StringUtils {

    public static boolean isBlank(String text) {
        return text == null || text.length() == 0;
    }

    public static String reverseString(String str) {
        return str == null ? null : new StringBuilder(str).reverse().toString();
    }
}
