package com.cc.dp.jackson.resp;

import com.cc.dp.jackson.DpJackson;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@DpJackson
public class UserOrderResp {

    private Integer id;
    private String name;
    private List<Order> orders;

//    @Data
    @AllArgsConstructor
    public static class Order{
        @JsonProperty("orderId")
        private Integer id;
        private String no;
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private Date cdt;

}
}