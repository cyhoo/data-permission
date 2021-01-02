package com.cc.dp.core;

import com.cc.dp.core.cache.DpPointCache;
import com.cc.dp.core.cache.DpPointNullCache;

public class DpPointProvider implements DpProvider{

    private DpPointCache dpPointCache = new DpPointNullCache();

    private DpPointSourceLoader dpPointSourceLoader;

    public void setDpPointCache(DpPointCache dpPointCache) {
        this.dpPointCache = dpPointCache;
    }

    public void setDpPointDetailsService(DpPointSourceLoader dpPointSourceLoader) {
        this.dpPointSourceLoader = dpPointSourceLoader;
    }

    @Override
    public DpAuthentication authenticate(DpAuthentication dpAuthentication) {
        boolean cacheHasPoint = true;
        String point = dpAuthentication.getPoint();
        DpPointDetails dpPointDetails = this.dpPointCache.getPointFromCache(point);
        if (dpPointDetails == null){
            cacheHasPoint = false;
            dpPointDetails = retrievePoint(point);
        }
        if (!cacheHasPoint){
            this.dpPointCache.putPointInCache(dpPointDetails);
        }
        DpPointAuthenticationToken dpPointAuthenticationToken = new DpPointAuthenticationToken(dpPointDetails.getFields(), dpPointDetails.getPoint());
        return dpPointAuthenticationToken;
    }

    private DpPointDetails retrievePoint(String point) {
        return this.dpPointSourceLoader.loadByPoint(point);
    }

}
