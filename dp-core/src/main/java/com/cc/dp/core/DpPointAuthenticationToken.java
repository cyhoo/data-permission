package com.cc.dp.core;


import java.util.Set;

public class DpPointAuthenticationToken extends AbsDpAuthentication{

    private String point;

    public DpPointAuthenticationToken(String point) {
        super(null);
        this.point = point;
    }

    public DpPointAuthenticationToken(Set<String> fields, String point) {
        super(fields);
        this.point = point;
    }

    @Override
    public String getPoint() {
        return this.point;
    }
}
