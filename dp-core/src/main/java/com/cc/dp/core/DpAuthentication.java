package com.cc.dp.core;

import java.util.Set;

public interface DpAuthentication {

    String getPoint();

    Set<String> getFields();

    boolean include(String field);
}