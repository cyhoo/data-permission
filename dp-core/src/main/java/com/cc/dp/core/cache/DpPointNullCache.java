package com.cc.dp.core.cache;

import com.cc.dp.core.DpPointDetails;

public class DpPointNullCache implements DpPointCache{

    @Override
    public DpPointDetails getPointFromCache(String point) {
        return null;
    }

    @Override
    public void putPointInCache(DpPointDetails dpPointDetails) {

    }

    @Override
    public void removePointFromCache(String point) {

    }
}
