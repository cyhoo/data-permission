package com.cc.dp.core.provider;

import com.cc.dp.core.DpAuthentication;
import com.cc.dp.core.DpLoader;
import com.cc.dp.core.DpToken;

public abstract class AbsDpProvider implements DpProvider{

    private DpLoader dpLoader;

    public AbsDpProvider(DpLoader dpLoader) {
        this.dpLoader = dpLoader;
    }

    public DpLoader getDpLoader() {
        return this.dpLoader;
    }

    @Override
    public DpAuthentication authenticate(DpToken dpToken) {
        Object attache = getDpLoader().load(dpToken.getPoint(), dpToken.getField());
        DpAuthentication dpAuthentication = convert(dpToken,attache);
        return dpAuthentication;
    }

    protected abstract DpAuthentication convert(DpToken dpToken, Object attache);
}
