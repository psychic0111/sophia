package com.yz.sophia.bsf.mq.rocketmq;

import com.yz.sophia.bsf.core.config.BsfConfiguration;
import com.yz.sophia.bsf.core.base.BsfEnvironmentEnum;
import com.yz.sophia.bsf.core.util.LogUtils;
import com.yz.sophia.bsf.core.util.PropertyUtils;
import lombok.Getter;
import lombok.var;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;
import org.springframework.util.StringUtils;

/**
 * @author: chejiangyi
 * @version: 2019-06-12 15:19
 * rocketmq配置初始化
 **/
@Configuration
@EnableConfigurationProperties(RocketMQProperties.class)
@Import(BsfConfiguration.class)
@Getter
public class RocketMQConfiguration implements InitializingBean {
    @Autowired
    RocketMQProperties rocketMQProperties;

    @Bean(destroyMethod = "close")
    @Lazy
    public RocketMQProducerProvider getRocketMqProducerProvider()
    {
        if(!StringUtils.isEmpty(rocketMQProperties.getNamesrvaddr()))
        {return new RocketMQProducerProvider();}
        else
        { return null;}
    }

    @Bean(destroyMethod = "close")
    @Lazy
    public RocketMQConsumerProvider getRocketMqConsumerProvider()
    {
        if(!StringUtils.isEmpty(rocketMQProperties.getNamesrvaddr()))
        {return new RocketMQConsumerProvider();}
        else
        { return null;}
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        var namesrvaddr=rocketMQProperties.getNamesrvaddr();
        if(namesrvaddr.length()==0)
        {
            namesrvaddr = PropertyUtils.getPropertyCache(BsfEnvironmentEnum.RocketMQ_DEV.getServerkey(),"");
        }
        rocketMQProperties.setNamesrvaddr(namesrvaddr);
        LogUtils.info(RocketMQConfiguration.class,RocketMQProperties.Project,"已启动!!! "+RocketMQProperties.BSfRocketMQNameSrvaddr+"="+namesrvaddr);
    }

}
