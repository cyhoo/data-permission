package com.cc.dp.core.jackson;

import com.cc.dp.core.adapter.DpAdapter;
import com.cc.dp.core.key.DpKeyGenerator;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class JacksonDpFilter<K> extends SimpleBeanPropertyFilter {

    private DpKeyGenerator<K> dpKeyGenerator;
    private DpAdapter<K> dpAdapter;

    public JacksonDpFilter(DpKeyGenerator<K> dpKeyGenerator, DpAdapter<K> dpAdapter) {
        this.dpKeyGenerator = dpKeyGenerator;
        this.dpAdapter = dpAdapter;
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        super.serializeAsField(pojo, jgen, provider, writer);
    }
}
