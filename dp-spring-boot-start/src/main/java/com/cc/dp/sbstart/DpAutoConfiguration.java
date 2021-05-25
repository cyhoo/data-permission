package com.cc.dp.sbstart;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableConfigurationProperties(DpProperties.class)
@ConditionalOnProperty(prefix = "dp",name = "enable",havingValue = "true")
public class DpAutoConfiguration {

    @Bean
    public List<String> alist(){
        return new ArrayList<>();
    }
}