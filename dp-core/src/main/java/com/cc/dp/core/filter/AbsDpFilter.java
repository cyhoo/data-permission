package com.cc.dp.core.filter;

import com.cc.dp.core.DpToken;
import com.cc.dp.core.DpManager;
import com.cc.dp.core.annotation.DpPoint;

public abstract class AbsDpFilter {

    private DpManager dpManager;

    protected boolean include(Object pojo, String field){
        DpPoint dpPoint = pojo.getClass().getAnnotation(DpPoint.class);
        if (dpPoint == null){
            return false;
        }
        String point = dpPoint.value();
        if (point.isEmpty()){
            point = pojo.getClass().getName();
        }
        DpToken dpToken = new DpToken(point,field);
        return this.getDpManager().authenticate(dpToken).include();
    }

    public DpManager getDpManager() {
        return dpManager;
    }
}
