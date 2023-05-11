package com.digivisions.assessment.utils;

import com.digivisions.assessment.managingfiles.config.ContextStorage;

public class SecurityUtil {

    public static String getCurrentUser() {
        return ContextStorage.getUsername();
    }
}
