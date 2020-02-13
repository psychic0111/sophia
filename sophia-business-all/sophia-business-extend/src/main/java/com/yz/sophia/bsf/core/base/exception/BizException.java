package com.yz.sophia.bsf.core.base.exception;


import com.yz.sophia.bsf.core.base.enums.ErrorCodeEnum;

/**
 * Created by yanglikai on 2019/5/28.
 */
public class BizException extends RuntimeException {
  private static final long serialVersionUID = 746403296908484046L;

  private int code;

  public BizException() {
  }

  public BizException(String message) {
    super(message);
  }

  public BizException(Throwable cause) {
    super(cause);
  }

  public BizException(String message, Throwable cause) {
    super(message, cause);
  }

  public BizException(int code, String message) {
    super(message);
    this.code = code;
  }

  public BizException(int code, String messageFormat, Object... args) {
    super(String.format(messageFormat, args));
    this.code = code;
  }

  public BizException(ErrorCodeEnum codeEnum, Object... args) {
    super(String.format(codeEnum.msg(), args));
    this.code = codeEnum.code();
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}
