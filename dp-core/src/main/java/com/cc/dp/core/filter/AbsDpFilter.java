package com.cc.dp.core.filter;

import com.cc.dp.core.DpPointAuthenticationToken;
import com.cc.dp.core.provider.DpProvider;
import com.cc.dp.core.annotation.DpPoint;

public abstract class AbsDpFilter {

    private DpProvider dpProvider;

    public AbsDpFilter(DpProvider dpProvider) {
        this.dpProvider = dpProvider;
    }

    protected boolean include(Object pojo, String field){
        DpPoint dpPoint = pojo.getClass().getAnnotation(DpPoint.class);
        if (dpPoint == null){
            return false;
        }
        String point = dpPoint.value();
        if (point.isEmpty()){
            point = pojo.getClass().getName();
        }
        DpPointAuthenticationToken dpPointAuthenticationToken = new DpPointAuthenticationToken(point);
        return this.dpProvider.authenticate(dpPointAuthenticationToken).include(field);
    }


}
