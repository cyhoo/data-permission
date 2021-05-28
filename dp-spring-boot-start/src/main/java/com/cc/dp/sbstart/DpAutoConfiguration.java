package com.cc.dp.sbstart;

import com.cc.dp.jackson.JacksonDpFilterMixIn;
import com.cc.dp.jackson.JsonFilterId;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Configuration
@EnableConfigurationProperties(DpProperties.class)
@ConditionalOnProperty(prefix = "dp",name = "enable",havingValue = "true")
public class DpAutoConfiguration {

    @Bean
    @ConditionalOnClass(MappingJackson2HttpMessageConverter.class)
    @ConditionalOnBean(MappingJackson2HttpMessageConverter.class)
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter,
                                                                                   FilterProvider filterProvider){
        ObjectMapper objectMapper = mappingJackson2HttpMessageConverter.getObjectMapper();
        objectMapper.setFilterProvider(filterProvider);
        objectMapper.addMixIn(Object.class, JacksonDpFilterMixIn.class);
        return mappingJackson2HttpMessageConverter;
    }


    @Bean
    @ConditionalOnBean(PropertyFilter.class)
    public FilterProvider filterProvider(List<PropertyFilter> propertyFilters){
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider();
        simpleFilterProvider.setDefaultFilter(SimpleBeanPropertyFilter.serializeAll());
        Optional.ofNullable(propertyFilters).orElse(Collections.emptyList()).forEach(propertyFilter -> {
            JsonFilterId jsonFilterId = AnnotationUtils.findAnnotation(propertyFilter.getClass(), JsonFilterId.class);
            if (jsonFilterId != null){
                simpleFilterProvider.addFilter(jsonFilterId.value(),propertyFilter);
            }
        });
        return simpleFilterProvider;
    }
}