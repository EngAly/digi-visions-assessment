package com.digivisions.assessment.managingfiles.config;

public class ContextStorage {

    private static ThreadLocal<String> CONTEXT = new ThreadLocal<>();

    public static void setUsername(String username) {
        CONTEXT.set(username);
    }

    public static String getUsername() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
