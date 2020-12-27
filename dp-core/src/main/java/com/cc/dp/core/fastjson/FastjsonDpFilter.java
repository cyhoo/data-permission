package com.cc.dp.core.fastjson;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.cc.dp.core.adapter.DpAdapter;
import com.cc.dp.core.key.DpKeyGenerator;

public class FastjsonDpFilter<K> implements PropertyFilter {

    private DpKeyGenerator<K> dpKeyGenerator;
    private DpAdapter<K> dpAdapter;

    public FastjsonDpFilter(DpKeyGenerator<K> dpKeyGenerator, DpAdapter<K> dpAdapter) {
        this.dpKeyGenerator = dpKeyGenerator;
        this.dpAdapter = dpAdapter;
    }

    @Override
    public boolean apply(Object object, String name, Object value) {
        return false;
    }
}
