package com.leads.assesment.comp;

import lombok.Data;

@Data
//@Component
//@ConfigurationProperties("custom")
public class ApplicationPropertiesConf {
    private String host;
    private String port;
    private String username;
    private String password;
}
