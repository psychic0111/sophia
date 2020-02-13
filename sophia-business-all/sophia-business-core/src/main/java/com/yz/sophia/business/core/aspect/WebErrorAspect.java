package com.yz.sophia.business.core.aspect;

import com.yz.sophia.business.api.entity.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author Huang Zhaoping
 */
@Slf4j
@Aspect
public class WebErrorAspect {

    @Around("within(@org.springframework.web.bind.annotation.RestController *)")
    public Object handleRestController(ProceedingJoinPoint point) throws Throwable {
        return handleError(point);
    }

    @Around("within(@org.springframework.stereotype.Controller *)")
    public Object handleController(ProceedingJoinPoint point) throws Throwable {
        return handleError(point);
    }

    private Object handleError(ProceedingJoinPoint point) throws Throwable {
        try {
            return point.proceed();
        } catch (Throwable e) {
            MethodSignature signature = (MethodSignature) point.getSignature();
            if (CommonResponse.class.isAssignableFrom(signature.getReturnType())) {
                loggerError(point, e);
                return CommonResponse.error(e);
            }
            throw e;
        }
    }

    private void loggerError(ProceedingJoinPoint point, Throwable e) {
        if (!log.isWarnEnabled()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        sb.append(method.getDeclaringClass().getSimpleName()).append('.').append(method.getName()).append(" error with args: ");
        Object[] values = point.getArgs();
        if (values.length == 0) {
            sb.append("{}");
        } else {
            sb.append("{");
            String[] names = signature.getParameterNames();
            for (int i = 0; i < values.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append(names[i]).append("=").append(values[i]);
            }
            sb.append("}");
        }
        log.warn(sb.toString(), e);
    }
}
