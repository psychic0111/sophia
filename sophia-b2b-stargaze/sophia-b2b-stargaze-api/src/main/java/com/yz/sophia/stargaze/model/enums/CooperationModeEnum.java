package com.yz.sophia.stargaze.model.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CooperationModeEnum class
 * 合作模式：01长期客户；02临时客户
 * @author huyalin
 */
public enum CooperationModeEnum {
    LONG_TERM("01", "长期客户"),
    TEMP("02", "临时客户");

    private String code;
    private String name;

    CooperationModeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    private static final Map<String, CooperationModeEnum> valueLookup = new ConcurrentHashMap<>(values().length);
    static {
        for (CooperationModeEnum type : EnumSet.allOf(CooperationModeEnum.class)) {
            valueLookup.put(type.code, type);
        }
    }

    public static CooperationModeEnum resolve(String code) {

        return (code != null ? valueLookup.get(code) : null);
    }

    public static String resolveName(String code) {
        CooperationModeEnum mode = resolve(code);
        return mode == null ? "" : mode.getName();
    }
}
