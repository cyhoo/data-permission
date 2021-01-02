package com.cc.dp.core.filter.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.cc.dp.core.provider.DpProvider;
import com.cc.dp.core.filter.AbsDpFilter;

public class FastjsonDpFilter extends AbsDpFilter implements PropertyFilter {

    public FastjsonDpFilter(DpProvider dpProvider) {
        super(dpProvider);
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        return super.include(object,name);
    }
}
