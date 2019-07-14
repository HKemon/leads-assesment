package com.leads.assesment.comp;

import lombok.Data;

/*
 * Stores the application properties values
 */

@Data
public class ApplicationPropertiesConf {
    private String host;
    private String port;
    private String database;
    private String username;
    private String password;
}
