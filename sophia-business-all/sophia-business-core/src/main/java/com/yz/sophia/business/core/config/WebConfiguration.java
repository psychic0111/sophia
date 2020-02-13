package com.yz.sophia.business.core.config;

import com.yz.sophia.bsf.core.serialize.JsonSerializer;
import com.yz.sophia.bsf.core.util.PropertyUtils;
import com.yz.sophia.business.core.aspect.WebErrorAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author Huang Zhaoping
 */
@Configuration
public class WebConfiguration {

    @Bean
    @ConditionalOnProperty(name = "bsf.web.error.enabled", havingValue = "true")
    public WebErrorAspect webErrorAspect() {
        return new WebErrorAspect();
    }

    @Bean
    @ConditionalOnProperty(name = "bsf.web.cors.enabled", havingValue = "true")
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.addExposedHeader("login-token");

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }

    @Bean
    @ConditionalOnProperty(name = "bsf.web.serialize.enabled", havingValue = "true")
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter(){
        return new MappingJackson2HttpMessageConverter(JsonSerializer.getObjectMapper()
                .setTimeZone(TimeZone.getTimeZone(PropertyUtils.getSystemProperty("spring.jackson.time-zone","GMT+8")))
                .setDateFormat(new SimpleDateFormat(PropertyUtils.getSystemProperty("spring.jackson.date-format","yyyy-MM-dd HH:mm:ss"))));
    }

}
