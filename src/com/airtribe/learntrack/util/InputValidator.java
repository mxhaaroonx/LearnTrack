package com.airtribe.learntrack.util;

public class InputValidator {

    private InputValidator() {}

    public static boolean isNullOrEmpty(String value){
        return value==null || value.isBlank();
    }

    public static boolean isValidId(int id){
        return id>0;
    }

    public static boolean isValidStatus(String status) {
        return status.equals("ACTIVE") || status.equals("COMPLETED") || status.equals("CANCELLED");
    }

}
