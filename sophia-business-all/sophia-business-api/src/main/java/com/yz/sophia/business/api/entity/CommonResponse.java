package com.yz.sophia.business.api.entity;

import com.yz.sophia.business.api.enums.BizError;
import com.yz.sophia.business.api.exception.BusinessException;

/**
 * 常见返回response定义
 */
public class CommonResponse<T> {
    public static int SUCCESS = BizError.SUCCESS.getCode();
    public static int ERROR = BizError.SYSTEM_ERROR.getCode();
    public static String SUCCESS_MSG = "success";
    public static String ERROR_MSG = "system error";
    
    public CommonResponse() {
		super();
	}

	public static <T> CommonResponse<T> success(String message, T data) {
        return new CommonResponse<T>(SUCCESS, message, data);
    }

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<T>(SUCCESS, SUCCESS_MSG, data);
    }

    public static <T> CommonResponse<T> success() {
        return new CommonResponse<T>(SUCCESS, SUCCESS_MSG, null);
    }

    public static <T> CommonResponse<T> error(int code, String message, T data) {
        return new CommonResponse<T>(code, message, data);
    }

    public static <T> CommonResponse<T> error(int code, String message) {
        return new CommonResponse<T>(code, message, null);
    }

    public static <T> CommonResponse<T> error(String message, T data) {
        return new CommonResponse<T>(ERROR, message, data);
    }

    public static <T> CommonResponse<T> error(String message) {
        return new CommonResponse<T>(ERROR, message, null);
    }

    public static <T> CommonResponse<T> error() {
        return new CommonResponse<T>(ERROR, ERROR_MSG, null);
    }

    public static <T> CommonResponse<T> error(Throwable e) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return CommonResponse.error(be.getCode(), be.getMessage());
        } else {
            return CommonResponse.error();
        }
    }

    protected int code;
    protected String message;
    protected T data;

    public CommonResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
