package com.naado.cityscapesite.enums;

import java.util.ArrayList;
import java.util.List;

public enum Problem {
    ACCOUNT,
    PLUGIN_PROBLEMS,
    GENERAL_PROBLEMS,
    SITE_PROBLEMS,
    GENERAL_REQUEST;


    @Override
    public String toString() {
        return super.toString();
    }

    public static List<String> getValues() {
        List<String> values = new ArrayList<>();
        values.add(ACCOUNT.toString());
        values.add(PLUGIN_PROBLEMS.toString());
        values.add(GENERAL_PROBLEMS.toString());
        values.add(SITE_PROBLEMS.toString());
        values.add(GENERAL_REQUEST.toString());
        return values;
    }
}
