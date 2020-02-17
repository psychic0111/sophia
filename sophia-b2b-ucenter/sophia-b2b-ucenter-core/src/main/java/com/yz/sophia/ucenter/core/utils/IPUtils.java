package com.yz.sophia.ucenter.core.utils;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPUtils {
    /**
     * 将字符串表示的ip地址转换为long表示.
     *
     * @param ip ip地址
     * @return 以32位整数表示的ip地址
     */
    public static long ip2Long(final String ip) {
        final String[] ipNums = ip.split("\\.");
        return (Long.parseLong(ipNums[0]) << 24)
                + (Long.parseLong(ipNums[1]) << 16)
                + (Long.parseLong(ipNums[2]) << 8)
                + (Long.parseLong(ipNums[3]));
    }

    public static String getIpAddress() {
        try {
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            while (allNetInterfaces.hasMoreElements()) {
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                if (netInterface.isLoopback() || netInterface.isVirtual() || !netInterface.isUp()) {
                    continue;
                } else {
                    Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                    while (addresses.hasMoreElements()) {
                        ip = addresses.nextElement();
                        if (ip != null && ip instanceof Inet4Address) {
                            return ip.getHostAddress();
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("IP地址获取失败" + e.toString());
        }
        return "";
    }

}
