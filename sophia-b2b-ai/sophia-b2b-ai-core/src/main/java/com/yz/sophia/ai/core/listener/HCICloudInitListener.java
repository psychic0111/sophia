package com.yz.sophia.ai.core.listener;

import com.sinovoice.hcicloudsdk.common.InitParam;
import com.yz.sophia.ai.core.config.AIConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
@Slf4j
public class HCICloudInitListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AIConfig aiConfig;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("run HCICloudInitListener event!");

        aiConfig.setInitParam(getInitParam());

        log.info(aiConfig.getInitParam().getParam(InitParam.AuthParam.PARAM_KEY_CLOUD_URL));
    }

    private InitParam getInitParam() {

        ApplicationHome h = new ApplicationHome(getClass());
        File jarF = h.getSource();
        System.out.println(jarF.getParentFile().toString());

        String authDirPath = aiConfig.applicationHome() + "/hci/auth";
        String logPath = aiConfig.applicationHome() + "/hci/log";

        File authDir = new File(authDirPath);
        if(!authDir.exists()){
            authDir.mkdirs();
        }
        File logDir = new File(logPath);
        if(!logDir.exists()){
            logDir.mkdirs();
        }
        // 前置条件：无
        InitParam initparam = new InitParam();

        // 授权文件所在路径，此项必填
        initparam
                .addParam(InitParam.AuthParam.PARAM_KEY_AUTH_PATH, authDirPath);

        // 是否自动访问云授权,详见 获取授权/更新授权文件处注释

        // 灵云云服务的接口地址，此项必填
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_CLOUD_URL, aiConfig.getApi().getServerAddress());

        // 开发者Key，此项必填，由捷通华声提供
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_DEVELOPER_KEY, aiConfig.getApi().getDevKey());

        // 应用Key，此项必填，由捷通华声提供
        initparam.addParam(InitParam.AuthParam.PARAM_KEY_APP_KEY, aiConfig.getApi().getAppKey());

        // 日志的路径，可选，如果不传或者为空则不生成日志
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_PATH, logPath);

        // 日志数目，默认保留多少个日志文件，超过则覆盖最旧的日志
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_COUNT, "5");

        // 日志大小，默认一个日志文件写多大，单位为K
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_FILE_SIZE, "1024");

        // 日志等级，0=无，1=错误，2=警告，3=信息，4=细节，5=调试，SDK将输出小于等于logLevel的日志信息
        initparam.addParam(InitParam.LogParam.PARAM_KEY_LOG_LEVEL, "5");

        return initparam;
    }
}
