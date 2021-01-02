package com.cc.dp.core.provider;

import com.cc.dp.core.AbsDpAuthentication;
import com.cc.dp.core.DpAuthentication;

import java.util.Set;

public class DpPointAllIncludeProvider implements DpProvider{
    @Override
    public DpAuthentication authenticate(DpAuthentication dpAuthentication) {
        return new AllIncludeAuthentication(null);
    }


    protected static class AllIncludeAuthentication extends AbsDpAuthentication{

        public AllIncludeAuthentication(Set<String> fields) {
            super(fields);
        }

        @Override
        public String getPoint() {
            return null;
        }

        @Override
        public boolean include(String field) {
            return true;
        }
    }
}
