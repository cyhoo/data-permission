package com.cc.dp.jackson.filter;

import com.cc.dp.core.DpPointInfo;
import com.cc.dp.core.filter.AbsDpFilter;
import com.cc.dp.jackson.Constant;
import com.cc.dp.jackson.JsonFilterId;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import sun.reflect.misc.FieldUtil;

import java.lang.reflect.Field;

@JsonFilterId(Constant.DP_FILTER_ID)
public class JacksonDpFilter extends AbsDpFilter implements PropertyFilter {
    @Override
    public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        if (this.include(pojo,writer)) {
            writer.serializeAsField(pojo, gen, provider);
        } else if (!gen.canOmitFields()) {
            writer.serializeAsOmittedField(pojo, gen, provider);
        }
    }

    @Override
    public void serializeAsElement(Object elementValue, JsonGenerator gen, SerializerProvider provider, PropertyWriter writer) throws Exception {
        writer.serializeAsElement(elementValue, gen, provider);
    }

    @Override
    public void depositSchemaProperty(PropertyWriter writer, ObjectNode propertiesNode, SerializerProvider provider) throws JsonMappingException {
        writer.depositSchemaProperty(propertiesNode, provider);
    }

    @Override
    public void depositSchemaProperty(PropertyWriter writer, JsonObjectFormatVisitor objectVisitor, SerializerProvider provider) throws JsonMappingException {
        writer.depositSchemaProperty(objectVisitor, provider);
    }

    private boolean include(Object pojo, PropertyWriter writer) {
        //取值优先使用method，否则再用field

        DpPointInfo dpPointInfo = new DpPointInfo();
        dpPointInfo.setObject(pojo);
        dpPointInfo.setField(writer.getName());
        dpPointInfo.setValue(null);
        return super.include(dpPointInfo);
    }

    @Override
    protected String buildPoint(DpPointInfo pointInfo)  {


        return null;
    }
}