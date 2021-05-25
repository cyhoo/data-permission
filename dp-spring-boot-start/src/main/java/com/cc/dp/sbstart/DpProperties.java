package com.cc.dp.sbstart;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "dp")
public class DpProperties {
    private boolean enable;
}