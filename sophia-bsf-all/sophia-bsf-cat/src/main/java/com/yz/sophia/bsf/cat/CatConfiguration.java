package com.yz.sophia.bsf.cat;


import com.yz.sophia.bsf.cat.remote.CatFeginRequestInterceptor;
import com.yz.sophia.bsf.core.util.PropertyUtils;
import lombok.var;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import com.dianping.cat.Cat;
import com.yz.sophia.bsf.core.base.BsfEnvironmentEnum;
import com.yz.sophia.bsf.core.config.BsfConfiguration;
import com.yz.sophia.bsf.core.util.LogUtils;

/**
 * @author: chejiangyi
 * @version: 2019-05-27 17:18
 **/
@org.springframework.context.annotation.Configuration
@ConditionalOnProperty(name = "bsf.cat.enabled", havingValue = "true")
@EnableConfigurationProperties(CatProperties.class)
@Import(value = {BsfConfiguration.class,CatMybatisPluginConfiguration.class})
public class CatConfiguration implements InitializingBean {

    @Autowired
    private CatProperties catPropeties;
    
    @Override
    public void afterPropertiesSet() throws Exception {
        var catServerUrl = catPropeties.getCatServerUrl();
        if(catPropeties.getCatServerUrl().length()==0)
        {
            catServerUrl = PropertyUtils.getPropertyCache(BsfEnvironmentEnum.CAT_DEV.getServerkey(),"");
        }

        Cat.initializeByDomain(PropertyUtils.getPropertyCache(CatProperties.SpringApplicationName,""),catServerUrl.split(","));
        LogUtils.info(CatConfiguration.class,CatProperties.Project,"已启动!!!"+" "+CatProperties.CatServerUrl+"="+ catServerUrl);
    }

    @Bean
    @ConditionalOnProperty(name = "bsf.cat.filter", havingValue = "cross")
    public CatFeginRequestInterceptor catFeginRequestInterceptor(){
        return new CatFeginRequestInterceptor();
    }
}
