package com.cxytiandi.sharding.config;

import org.apache.shardingsphere.core.yaml.config.YamlConfiguration;

public class MyStandardConfiguration implements YamlConfiguration {

    private String name;

    private String card;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

}
