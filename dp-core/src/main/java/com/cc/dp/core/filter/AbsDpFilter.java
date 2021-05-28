package com.cc.dp.core.filter;

import com.cc.dp.core.DpPointInfo;
import com.cc.dp.core.provider.DpProvider;
import com.cc.dp.core.provider.SimpleDpProvider;

public abstract class AbsDpFilter implements DpFilter{

    private DpProvider dpProvider;

    public AbsDpFilter() {
        dpProvider = new SimpleDpProvider();
    }

    public AbsDpFilter(DpProvider dpProvider) {
        this.dpProvider = dpProvider;
    }

    public DpProvider getDpProvider() {
        return dpProvider;
    }

    public void setDpProvider(DpProvider dpProvider) {
        this.dpProvider = dpProvider;
    }

    @Override
    public boolean include(DpPointInfo pointInfo) {
        String point = buildPoint(pointInfo);
        return this.dpProvider.contain(point);
    }

    protected abstract String buildPoint(DpPointInfo pointInfo);
}