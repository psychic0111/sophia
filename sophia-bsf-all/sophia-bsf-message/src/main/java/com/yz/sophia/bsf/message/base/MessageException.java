package com.yz.sophia.bsf.message.base;

import com.yz.sophia.bsf.core.base.BsfException;

/**
 * @author: chejiangyi
 * @version: 2019-06-13 17:45
 **/
public class MessageException extends BsfException {
    public MessageException(Exception exp)
    {
        super(exp);
    }
    public MessageException(String message)
    {
        super(message);
    }
}
