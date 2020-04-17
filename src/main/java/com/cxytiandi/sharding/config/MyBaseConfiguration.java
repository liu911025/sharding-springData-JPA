package com.cxytiandi.sharding.config;

import org.apache.shardingsphere.core.yaml.config.YamlConfiguration;

public class MyBaseConfiguration implements YamlConfiguration {

    private MyStandardConfiguration standard;

    private MyInlineConfiguration inline;

    public MyStandardConfiguration getStandard() {
        return standard;
    }

    public void setStandard(MyStandardConfiguration standard) {
        this.standard = standard;
    }

    public MyInlineConfiguration getInline() {
        return inline;
    }

    public void setInline(MyInlineConfiguration inline) {
        this.inline = inline;
    }
}
