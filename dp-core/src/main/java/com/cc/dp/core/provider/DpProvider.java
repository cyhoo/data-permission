package com.cc.dp.core.provider;

import com.cc.dp.core.DpAuthentication;

public interface DpProvider {

    DpAuthentication authenticate(DpAuthentication dpAuthentication);
}
