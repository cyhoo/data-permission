package com.cc.dp.core.provider;

import com.cc.dp.core.DpAuthentication;
import com.cc.dp.core.DpToken;

public interface DpProvider {

    DpAuthentication authenticate(DpToken dpToken);
}
