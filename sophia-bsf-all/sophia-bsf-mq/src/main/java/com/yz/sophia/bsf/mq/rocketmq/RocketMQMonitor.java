package com.yz.sophia.bsf.mq.rocketmq;

import com.yz.sophia.bsf.core.common.Collector;

/**
 * @author Huang Zhaoping
 */
public class RocketMQMonitor {
    private static String name="rocketmq.info";

    public static Collector.Hook hook(){
        return Collector.Default.hook(name+".hook");
    }
}
