package com.yz.sophia.bsf.core.util.misc;


import javax.servlet.http.HttpServletRequest;

/**
 * Created by yanglikai on 2019/5/28.
 */
public final class IpUtil {

  private static final String UNKNOWN = "UNKNOWN";

  private IpUtil() {
  }

  public static String getIpAddr(HttpServletRequest request) {
    String ip = request.getHeader("X-Real-IP");
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("x-forwarded-for");
    }

    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("Proxy-Client-IP");
    }
    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getHeader("WL-Proxy-Client-IP");
    }

    if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
      ip = request.getRemoteAddr();
    }

    //防止多级代理时返回过个ip。
    if (ip != null && ip.indexOf(',') != -1) {
      ip = ip.substring(0, ip.indexOf(','));
    }
    return ip;
  }
}
