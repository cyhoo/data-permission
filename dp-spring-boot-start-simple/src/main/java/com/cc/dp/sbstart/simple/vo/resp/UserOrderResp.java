package com.cc.dp.sbstart.simple.vo.resp;

import java.util.Date;
import java.util.List;

import com.cc.dp.jackson.DpJackson;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@DpJackson
public class UserOrderResp {

    private Integer id;
    private String name;
    private List<Order> orders;

    @Data
    @AllArgsConstructor
    public static class Order{
        @JsonProperty("orderId")
        private Integer id;
        private String no;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date cdt;
    }
}