package com.yz.sophia.bsf.core.security.filter;

import com.yz.sophia.bsf.core.base.enums.ErrorCodeEnum;
import com.yz.sophia.bsf.core.base.exception.BizException;
import com.yz.sophia.bsf.core.base.wrapper.WrapMapper;
import com.yz.sophia.bsf.core.base.wrapper.Wrapper;
import com.yz.sophia.bsf.core.security.service.IUserTokenService;
import com.yz.sophia.bsf.core.security.user.SecurityUser;
import com.yz.sophia.bsf.core.security.user.UserContext;
import com.yz.sophia.bsf.core.util.json.JSONUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yanglikai on 2019/4/16.
 */
public class TokenAuthenticationFilter implements Filter {

  private static final String[] HEADERS = {"login-token", "x-token"};

  @Autowired
  private IUserTokenService userTokenService;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    /* 前端跨域请求处理 */
    setupResponseHeader((HttpServletRequest) request, (HttpServletResponse) response);

    /* Token验证 */
    try {
      String token = fetchToken((HttpServletRequest) request);

      SecurityUser securityUser = userTokenService.checkToken(token);

      UserContext.set(securityUser);

      chain.doFilter(request, response);
    } catch (BizException ex) {
      Wrapper wrapper = WrapMapper
          .wrap(ErrorCodeEnum.UC40001001.code(), ErrorCodeEnum.UC40001001.msg());

      handleException(response, wrapper);
    } catch (Exception ex) {
      Wrapper wrapper =
          WrapMapper.wrap(ErrorCodeEnum.GL99990500.code(), ErrorCodeEnum.GL99990500.msg());

      handleException(response, wrapper);
    }
  }

  private boolean isOptionsRequest(HttpServletRequest request) {
    if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
      return true;
    }

    return false;
  }

  private void setupResponseHeader(HttpServletRequest request, HttpServletResponse response) {
    String origin = request.getHeader("Origin");
    if (origin != null) {
      response.setHeader("Access-Control-Allow-Origin", origin);
    } else {
      response.setHeader("Access-Control-Allow-Origin", "*");
    }
    String allowHeaders = StringUtils.join(HEADERS, ", ");
    response.setHeader("Access-Control-Allow-Headers",
        "origin, content-type, accept, authorization, " + allowHeaders);
    response.setHeader("Access-Control-Expose-Headers", "Content-Disposition, " + allowHeaders);
    response.setHeader("Access-Control-Allow-Credentials", "true");
    response.setHeader("Access-Control-Max-Age", "86400");
    response
        .setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD, PATCH");

    if (HttpMethod.OPTIONS.name().equals(request.getMethod())) {
      response.setStatus(HttpServletResponse.SC_NO_CONTENT);
      return;
    }
  }

  private void handleException(ServletResponse response, Wrapper wrapper) throws IOException {
    response.setContentType("application/json;charset=UTF-8");

    PrintWriter writer = response.getWriter();
    writer.write(JSONUtil.tJSON(wrapper));
    writer.flush();
    writer.close();
  }

  @Override
  public void destroy() {

  }

  private String fetchToken(HttpServletRequest request) {
    for (String header : HEADERS) {
      String token = request.getHeader(header);
      if (StringUtils.isNotBlank(token)) {
        return token;
      }
    }

    return null;
  }
}
