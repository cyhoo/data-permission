package com.cc.dp.core;

public class DpToken {

    private String point;
    private String field;

    public DpToken(String point, String field) {
        this.point = point;
        this.field = field;
    }

    public String getPoint() {
        return point;
    }

    public String getField() {
        return field;
    }
}
