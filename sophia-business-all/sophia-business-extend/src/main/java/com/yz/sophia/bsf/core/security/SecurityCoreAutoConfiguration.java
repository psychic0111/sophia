package com.yz.sophia.bsf.core.security;

import com.yz.sophia.bsf.core.security.filter.TokenAuthenticationFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.servlet.Filter;

/**
 * Created by yanglikai on 2019/4/16.
 */
public class SecurityCoreAutoConfiguration {

  @Bean
  public FilterRegistrationBean filterRegistrationBean() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(tokenAuthenticationFilter());
    registration.setName("tokenAuthenticationFilter");
    registration.addUrlPatterns("/api/*");

    return registration;
  }

  @Bean
  public Filter tokenAuthenticationFilter() {
    return new TokenAuthenticationFilter();
  }

  @Bean
  public CorsFilter corsFilter() {
    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    final CorsConfiguration config = new CorsConfiguration();

    // 允许cookies跨域
    config.setAllowCredentials(true);
    // #允许向该服务器提交请求的URI，*表示全部允许，在SpringMVC中，如果设成*，会自动转成当前请求头中的Origin
    config.addAllowedOrigin("*");
    // #允许访问的头信息,*表示全部
    config.addAllowedHeader("*");
    // 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
    config.setMaxAge(18000L);
    // 允许提交请求的方法，*表示全部允许
    config.addAllowedMethod("OPTIONS");
    config.addAllowedMethod("HEAD");
    config.addAllowedMethod("GET");
    config.addAllowedMethod("PUT");
    config.addAllowedMethod("POST");
    config.addAllowedMethod("DELETE");
    config.addAllowedMethod("PATCH");
    source.registerCorsConfiguration("/**", config);

    return new CorsFilter(source);
  }
}
