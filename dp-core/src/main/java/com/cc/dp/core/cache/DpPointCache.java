package com.cc.dp.core.cache;

import com.cc.dp.core.DpPointDetails;

import java.util.Set;

public interface DpPointCache {

    DpPointDetails getPointFromCache(String point);

    void putPointInCache(DpPointDetails dpPointDetails);

    void removePointFromCache(String point);
}
