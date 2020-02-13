package com.yz.sophia.bsf.core.config.base;

/**
 * @author: chejiangyi 默认环境枚举
 * @version: 2019-05-27 13:38
 **/
public enum BsfEnvironment {
  JOB_DEV(Environment.dev, "dev.job.yzsophia.cn"),
  //JOB_TEST(Environment.test,"test.job.yzsophia.cn"),
  JOB_PRD(Environment.prd, "prd.job.yzsophia.cn"),

  APOLLO_DEV(Environment.dev, "10.252.193.16"),
  //APOLLO_TEST(Environment.test,"test.apollo.yzsophia.cn"),
  APOLLO_PRD(Environment.prd, "prd.apollo.yzsophia.cn"),

  CAT_DEV(Environment.dev, "dev.cat.yzsophia.cn"),
  //CAT_TEST(Environment.test,"test.cat.yzsophia.cn"),
  CAT_PRD(Environment.prd, "prd.cat.yzsophia.cn"),

  ELK_DEV(Environment.dev, "dev.elk.yzsophia.cn"),
  //ELK_TEST(Environment.test,"test.elk.yzsophia.cn"),
  ELK_PRD(Environment.prd, "prd.elk.yzsophia.cn"),

  ;
  private Environment env;
  private String ip;

  BsfEnvironment(Environment env, String ip) {
    this.env = env;
    this.ip = ip;
  }

  public Environment getEnv() {
    return env;
  }

  public String getIp() {
    return ip;
  }
}
