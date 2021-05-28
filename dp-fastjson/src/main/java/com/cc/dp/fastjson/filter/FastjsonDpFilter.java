package com.cc.dp.fastjson.filter;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.cc.dp.core.DpPointInfo;
import com.cc.dp.core.filter.AbsDpFilter;

public class FastjsonDpFilter extends AbsDpFilter implements PropertyFilter {

    @Override
    public boolean apply(Object object, String name, Object value) {
        DpPointInfo dpPointInfo = new DpPointInfo();
        dpPointInfo.setObject(object);
        dpPointInfo.setField(name);
        dpPointInfo.setValue(value);
        return super.include(dpPointInfo);
    }

    @Override
    protected String buildPoint(DpPointInfo pointInfo) {
        //TODO 构建点
        return null;
    }
}