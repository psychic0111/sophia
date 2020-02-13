package com.yz.sophia.bsf.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.yz.sophia.bsf.core.config.BsfConfiguration;
import com.yz.sophia.bsf.core.util.LogUtils;
import com.yz.sophia.bsf.core.util.PropertyUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: chejiangyi
 * @version: 2019-05-28 09:26
 **/
@Configuration
@ConditionalOnProperty(name = "bsf.apollo.enabled", havingValue = "true")
@Import(BsfConfiguration.class)
@EnableApolloConfig //{"bsf","application"}
public class ApolloConfiguration implements InitializingBean  {

    @Override
    public void afterPropertiesSet()
    {
        LogUtils.info(ApolloConfiguration.class,ApolloProperties.Project,"已启动!!!"+" "+ApolloProperties.ApolloMeta+"="+ PropertyUtils.getPropertyCache(ApolloProperties.ApolloMeta,""));
    }

}
