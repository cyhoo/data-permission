package com.cc.dp.core.provider;

import com.cc.dp.core.DpAuthentication;
import com.cc.dp.core.DpLoader;
import com.cc.dp.core.DpToken;
import com.cc.dp.core.IncludeDpAuthentication;

public class DpIncludeProvider extends AbsDpProvider {

    public DpIncludeProvider(DpLoader dpLoader) {
        super(dpLoader);
    }

    @Override
    protected DpAuthentication convert(DpToken dpToken, Object attache) {
        IncludeDpAuthentication includeDpAuthentication = new IncludeDpAuthentication();
        includeDpAuthentication.setDpToken(dpToken);
        includeDpAuthentication.setAttache(dpToken);
        return includeDpAuthentication;
    }

}
