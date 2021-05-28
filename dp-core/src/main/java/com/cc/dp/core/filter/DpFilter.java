package com.cc.dp.core.filter;

import com.cc.dp.core.DpPointInfo;

public interface DpFilter {

    boolean include(DpPointInfo pointInfo);
}