package com.cc.dp.core.jackson;

import com.cc.dp.core.DpMatcher;
import com.cc.dp.core.annotation.DpField;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;

public class JacksonDpFilter extends SimpleBeanPropertyFilter {

    private DpMatcher dpMatcher;

    public JacksonDpFilter(DpMatcher dpMatcher) {
        this.dpMatcher = dpMatcher;
    }

    @Override
    public void serializeAsField(Object pojo, JsonGenerator jgen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        if (this.include(pojo,writer)) {
            writer.serializeAsField(pojo, jgen, provider);
        } else if (!jgen.canOmitFields()) {
            writer.serializeAsOmittedField(pojo, jgen, provider);
        }
    }

    protected boolean include(Object pojo,PropertyWriter writer){
        DpField dpField = writer.getAnnotation(DpField.class);
        if (dpField == null){
            return true;
        }
        String field = dpField.value();
        if (field.isEmpty()){
            field = writer.getName();
        }
        String node = pojo.getClass().getName();
        return this.dpMatcher.match(node,field);
    }
}
