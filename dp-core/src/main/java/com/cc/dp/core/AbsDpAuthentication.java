package com.cc.dp.core;

public abstract class AbsDpAuthentication implements DpAuthentication{

    private DpToken dpToken;
    private Object attache;

    public void setDpToken(DpToken dpToken) {
        this.dpToken = dpToken;
    }

    public void setAttache(Object attache) {
        this.attache = attache;
    }

    @Override
    public DpToken getPrincipal() {
        return this.dpToken;
    }

    @Override
    public Object getAttache() {
        return this.attache;
    }
}
