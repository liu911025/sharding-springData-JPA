package com.cxytiandi.sharding.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@Component
@ConfigurationProperties(prefix = "my.config")
public class MySpringBootConfigurationProperties extends MyBaseConfiguration {
    public MySpringBootConfigurationProperties() {
    }
}
