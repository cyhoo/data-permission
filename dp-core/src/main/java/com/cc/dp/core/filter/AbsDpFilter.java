package com.cc.dp.core.filter;

import com.cc.dp.core.DpPointProvider;
import com.cc.dp.core.DpPointAuthenticationToken;
import com.cc.dp.core.annotation.DpPoint;

public abstract class AbsDpFilter {

    private DpPointProvider dpPointProvider;

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
        return this.dpPointProvider.authenticate(dpPointAuthenticationToken).include(field);
    }

    public void setDpPointProvider(DpPointProvider dpPointProvider) {
        this.dpPointProvider = dpPointProvider;
    }
}
