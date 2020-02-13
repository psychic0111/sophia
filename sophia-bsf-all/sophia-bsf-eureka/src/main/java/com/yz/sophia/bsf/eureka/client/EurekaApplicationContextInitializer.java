package com.yz.sophia.bsf.eureka.client;

import com.yz.sophia.bsf.core.base.BsfEnvironmentEnum;
import com.yz.sophia.bsf.core.config.CoreProperties;
import com.yz.sophia.bsf.core.util.PropertyUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.StringUtils;

/**
 * Eureka 注册
 * @author: chejiangyi
 * @version: 2019-05-28 12:08
 **/
public class EurekaApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext context) {
        ConfigurableEnvironment environment = context.getEnvironment();
        if("false".equalsIgnoreCase(environment.getProperty(CoreProperties.BsfEnabled))){
            return;
        }
        this.initializeSystemProperty(environment);
    }

    void initializeSystemProperty(ConfigurableEnvironment environment) {
        String propertyValue = environment.getProperty(EurekaProperties.StringApplicationName);
        if(propertyValue==null)
        {   return; }

        propertyValue = environment.getProperty(EurekaProperties.BsfEurekaClientEnabled);
        if (StringUtils.isEmpty(propertyValue)|| "false".equalsIgnoreCase(propertyValue)) {
            {
                setDefaultProperty(EurekaProperties.EurekaClientEnabled,"false","关闭eureka client启动");
                return;
            }
        }
        setDefaultProperty(EurekaProperties.EurekaClientServiceUrlDefaultZone, environment.getProperty(BsfEnvironmentEnum.EUREKA_DEV.getServerkey(),""),"");
        setDefaultProperty(EurekaProperties.EurekaInstanceLeaseExpirationDurationInSencodes,"5","[eureka server调优]");
        setDefaultProperty(EurekaProperties.EurekaInstanceLeaseRenwalIntervalInSeconds,"2","[eureka server调优]");
        setDefaultProperty(EurekaProperties.EurekaInstancePerferIpAddress,"true","[eureka server调优]");
        setDefaultProperty(EurekaProperties.SpringMainAllowBeanDefinitionOverriding,"true","");
        setDefaultProperty(EurekaProperties.RibbonReadTimeOut,"30000","[eureka client调优]");
        setDefaultProperty(EurekaProperties.RibbonConnectTimeOut,"30000","[eureka client调优]");
        EurekaMonitor.init();
    }

    void setDefaultProperty(String key,String defaultPropertyValue,String message)
    {
        PropertyUtils.setDefaultInitProperty(EurekaApplicationContextInitializer.class,EurekaProperties.Project,key,defaultPropertyValue,message);
    }
}
