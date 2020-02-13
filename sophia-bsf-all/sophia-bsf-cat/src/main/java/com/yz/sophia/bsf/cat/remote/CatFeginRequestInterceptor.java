package com.yz.sophia.bsf.cat.remote;

import com.dianping.cat.Cat;
import feign.RequestInterceptor;
import feign.RequestTemplate;
/**
 * 调用链拦截器
 * @author: chejiangyi
 * @version: 2019-08-30 13:21
 **/
public class CatFeginRequestInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        CatRemoteContext context = new CatRemoteContext();
        Cat.logRemoteCallClient(context);
        requestTemplate.header(Cat.Context.ROOT, context.getProperty(Cat.Context.ROOT));
        requestTemplate.header(Cat.Context.CHILD, context.getProperty(Cat.Context.CHILD));
        requestTemplate.header(Cat.Context.PARENT,context.getProperty(Cat.Context.PARENT));
        requestTemplate.header("application.name", Cat.getManager().getDomain());
    }


}
