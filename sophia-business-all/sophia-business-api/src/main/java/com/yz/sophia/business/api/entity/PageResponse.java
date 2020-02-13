package com.yz.sophia.business.api.entity;

import com.yz.sophia.business.api.exception.BusinessException;

/**
 * @author: chejiangyi
 * @version: 2019-08-08 15:48
 **/
public class PageResponse<T> {
    private static final long serialVersionUID = -4428819306682179845L;

    public static <T> PageResponse<T> success(String message, Page<T> data) {
        return new PageResponse<T>(CommonResponse.SUCCESS, message, data);
    }

    public static <T> PageResponse<T> success(Page<T> data) {
        return new PageResponse<T>(CommonResponse.SUCCESS, CommonResponse.SUCCESS_MSG, data);
    }

    public static <T> PageResponse<T> success() {
        return new PageResponse<T>(CommonResponse.SUCCESS, CommonResponse.SUCCESS_MSG, null);
    }

    public static <T> PageResponse<T> error(int code, String message, Page<T> data) {
        return new PageResponse<T>(code, message, data);
    }

    public static <T> PageResponse<T> error(int code, String message) {
        return new PageResponse<T>(code, message, null);
    }

    public static <T> PageResponse<T> error(String message, Page<T> data) {
        return new PageResponse<T>(CommonResponse.ERROR, message, data);
    }

    public static <T> PageResponse<T> error(String message) {
        return new PageResponse<T>(CommonResponse.ERROR, message, null);
    }

    public static <T> PageResponse<T> error() {
        return new PageResponse<T>(CommonResponse.ERROR, CommonResponse.ERROR_MSG, null);
    }

    public static <T> PageResponse<T> error(Throwable e) {
        if (e instanceof BusinessException) {
            BusinessException be = (BusinessException) e;
            return PageResponse.error(be.getCode(), be.getMessage());
        } else {
            return PageResponse.error();
        }
    }

    protected int code;
    protected String message;
    protected Page<T> data;

    public PageResponse(int code, String message, Page<T> data) {
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

    public Page<T> getData() {
        return data;
    }
}

