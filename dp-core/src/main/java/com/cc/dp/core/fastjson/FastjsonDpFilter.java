package com.cc.dp.core.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.cc.dp.core.DpMatcher;
import com.cc.dp.core.annotation.DpPoint;

public class FastjsonDpFilter implements PropertyFilter {

    private DpMatcher dpMatcher;

    public FastjsonDpFilter(DpMatcher dpMatcher) {
        this.dpMatcher = dpMatcher;
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        DpPoint dpPoint = object.getClass().getAnnotation(DpPoint.class);
        if (dpPoint == null){
            return false;
        }
        String node = object.getClass().getName();
        String field = name;
        return this.dpMatcher.match(node,field);
    }
}
