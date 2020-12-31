package com.cc.dp.core;

public interface DpAuthentication {

    DpToken getPrincipal();

    boolean include();

    Object getAttache();
}
