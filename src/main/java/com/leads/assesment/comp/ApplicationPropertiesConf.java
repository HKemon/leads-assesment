package com.leads.assesment.comp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
//@Component
//@ConfigurationProperties("custom")
public class ApplicationPropertiesConf {
    private String host;
    private String port;
    private String username;
    private String password;
}
