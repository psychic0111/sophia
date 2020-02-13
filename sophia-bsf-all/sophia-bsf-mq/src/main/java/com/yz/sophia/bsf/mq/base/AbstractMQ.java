package com.yz.sophia.bsf.mq.base;

import com.yz.sophia.bsf.core.system.ProcessExitEvent;
import com.yz.sophia.bsf.core.util.LogUtils;
import com.yz.sophia.bsf.mq.MQProperties;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * @author: chejiangyi
 * @version: 2019-06-12 13:19
 * 消息队列对象抽象
 **/
@Data
public abstract class AbstractMQ implements AutoCloseable {

    private Object object;

    public AbstractMQ()
    {
        ProcessExitEvent.register(()->{
            try {
                this.close();
            }
            catch (Exception exp)
            {
                LogUtils.warn(AbstractMQ.class, MQProperties.Project,"应用退出时释放mq资源异常",exp);
            }
        },1,false);
    }

    protected void innerClose(Object object)
    {
        try {
            if (object != null) {
                LogUtils.debug(AbstractMQ.class, MQProperties.Project, "MQ准备释放内部资源...");
                String[] methods = {"close", "shutdown"};
                for (String name : methods) {
                    Method method = object.getClass().getDeclaredMethod(name);
                    if (method != null) {
                        method.invoke(object);
                    }
                }
            }
        }
        catch (Exception exp)
        {
            LogUtils.warn(AbstractMQ.class,MQProperties.Project,"MQ内部资源释放异常",exp);
        }
    }
}
