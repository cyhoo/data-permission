package com.cc.dp.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@JsonFilter(Constant.DP_FILTER_ID)
public @interface DpJackson {
}