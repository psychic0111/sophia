package com.yz.sophia.business.api.exception;

import com.yz.sophia.business.api.enums.BizError;

/**
 * 业务错误定义
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = -3942998119484283865L;

    private static final String PACKAGE_PREFIX;

    static {
        String[] paths = BusinessException.class.getPackage().getName().split("\\.");
        PACKAGE_PREFIX = paths[0] + "." + paths[1];
    }

    private int code;

    public BusinessException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BusinessException(int code, String message) {
        super(message);
        this.code = code;
    }

    public BusinessException(int code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.code = BizError.COMMON_ERROR.getCode();
    }

    public BusinessException(String message) {
        super(message);
        this.code = BizError.COMMON_ERROR.getCode();
    }

    public BusinessException(BizError error, Throwable cause) {
        this(error.getCode(), error.getMessage(), cause);
    }

    public BusinessException(BizError error) {
        this(error.getCode(), error.getMessage());
    }

    public int getCode() {
        return code;
    }

    @Override
    /**
     * 过滤非业务错误的堆栈信息
     */
    public synchronized Throwable fillInStackTrace() {
        Throwable throwable = super.fillInStackTrace();
        StackTraceElement[] stack = super.getStackTrace();
        if (stack == null) {
            return throwable;
        }
        int count = 0;
        for (int i = stack.length - 1; i >= 0; i--) {
            StackTraceElement e = stack[i];
            if (!e.getClassName().startsWith(PACKAGE_PREFIX) || e.getLineNumber() < 0) {
                stack[i] = null;
            } else {
                count++;
            }
        }
        if (count != stack.length) {
            StackTraceElement[] temp = new StackTraceElement[count];
            int index = 0;
            for (StackTraceElement e : stack) {
                if (e == null) {
                    continue;
                }
                temp[index++] = e;
            }
            stack = temp;
        }
        setStackTrace(stack);
        return throwable;
    }
}
