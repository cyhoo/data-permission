package com.cc.dp.jackson;

import com.cc.dp.jackson.filter.JacksonDpFilter;
import com.cc.dp.jackson.resp.UserOrderResp;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonObjectFormatVisitor;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test {

    public static void main(String[] args) throws JsonProcessingException {
        List<UserOrderResp.Order> orders = new ArrayList<>();
        orders.add(new UserOrderResp.Order(11,"no11",new Date(1621440000000L)));
        orders.add(new UserOrderResp.Order(12,"no12",new Date(1622304000000L)));
        UserOrderResp userOrderResp = new UserOrderResp(1,"admin",orders);

        JsonMapper jsonMapper = new JsonMapper();
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        simpleFilterProvider.addFilter(Constant.DP_FILTER_ID, new PropertyFilter() {
            @Override
            public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider provider, PropertyWriter writer) throws Exception {
                    if (this.include(pojo,writer)) {
                    writer.serializeAsField(pojo, gen, provider);
                } else if (!gen.canOmitFields()) {
                    writer.serializeAsOmittedField(pojo, gen, provider);
                }
            }

            private boolean include(Object pojo, PropertyWriter writer) {
                return true;
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
        });
        jsonMapper.setFilterProvider(simpleFilterProvider);
        jsonMapper.addMixIn(Object.class,JacksonDpFilterMixIn.class);

        System.out.println(jsonMapper.writeValueAsString(userOrderResp));
    }
}