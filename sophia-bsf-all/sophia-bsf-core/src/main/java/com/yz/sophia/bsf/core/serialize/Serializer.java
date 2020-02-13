package com.yz.sophia.bsf.core.serialize;

import java.lang.reflect.Type;

/**
 * @author Huang Zhaoping
 */
public interface Serializer {

    String serialize(Object object);

    <T> T deserialize(String str, Type type);

}
