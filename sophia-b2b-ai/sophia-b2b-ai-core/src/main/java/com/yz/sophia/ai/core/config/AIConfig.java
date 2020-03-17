package com.yz.sophia.ai.core.config;

import com.sinovoice.hcicloudsdk.common.InitParam;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;

import java.io.File;

@Data
@Component
@ConfigurationProperties(prefix = "insight")
public class AIConfig {

    @Autowired
    private ApiConfig api;

    private InitParam initParam;

    public String applicationHome(){
        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        return jarF.getParentFile().toString();     // jar所在目录
    }
}
