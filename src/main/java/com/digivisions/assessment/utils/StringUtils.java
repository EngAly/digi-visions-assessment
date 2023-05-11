package com.digivisions.assessment.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.Collection;

public class StringUtils {

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static boolean isBlank(String text) {
        return text == null || text.length() == 0;
    }

    public static String reverseString(String str) {
        return str == null ? null : new StringBuilder(str).reverse().toString();
    }

    public static String mapJsonToString(Object object) {

        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static boolean not(boolean value) {
        return !value;
    }

    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.isEmpty();
    }
}
