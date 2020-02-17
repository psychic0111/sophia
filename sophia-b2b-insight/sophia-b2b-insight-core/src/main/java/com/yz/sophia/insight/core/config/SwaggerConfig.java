package com.yz.sophia.insight.core.config;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Optional;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ApiListingBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ApiListingBuilderPlugin;
import springfox.documentation.spi.service.OperationBuilderPlugin;
import springfox.documentation.spi.service.contexts.ApiListingContext;
import springfox.documentation.spi.service.contexts.OperationContext;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable:false}")
    private boolean enable;
    @Value("${swagger.title:'Swagger API'}")
    private String title;
    @Value("${swagger.description:''}")
    private String description;
    @Value("${swagger.version:'1.0'}")
    private String version;


    @Bean
    public Docket customDocket() {
//        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
//            @Override
//            public boolean apply(RequestHandler input) {
//
//                //只有添加了ApiOperation注解的method才在API中显示
//                if (input.isAnnotatedWith(ApiOperation.class)&&
//                        input.findControllerAnnotation(Api.class).isPresent()&&
//                        input.findControllerAnnotation(RestController.class).isPresent())
//                {
//                    System.out.println(input.declaringClass().getName());
//                    return true;
//                }
//
//                return false;
//            }
//        };


        return new Docket(DocumentationType.SWAGGER_2)
                .enable(enable)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //.apis(Requ)
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public ApiDocBuilder apiDocBuilder() {
        return new ApiDocBuilder();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title(title).version(version).description(description).build();
    }

    private List<ApiKey> securitySchemes() {
        return Collections.singletonList(new ApiKey("TokenAuth", "login-token", "header"));
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder()
                .securityReferences(Arrays.asList(new SecurityReference("TokenAuth", new AuthorizationScope[]{new AuthorizationScope("global", "accessEverything")})))
                .forPaths(PathSelectors.any()).build());
    }

    public static class ApiDocBuilder implements ApiListingBuilderPlugin, OperationBuilderPlugin {

        @SuppressWarnings("unchecked")
        @Override
        public void apply(ApiListingContext context) {
            ApiListingBuilder builder = context.apiListingBuilder();
            builder.description("");
            Optional<? extends Class<?>> optional = context.getResourceGroup().getControllerClass();
            if (!optional.isPresent()) {
                return;
            }
            Api api = optional.get().getAnnotation(Api.class);
            //兼容继承模式的swagger生成
            if(api == null) {
                Type[] types = optional.get().getGenericInterfaces();
                if (types != null && types.length > 0) {
                    val type = Arrays.stream(types).filter(c ->((Class)c).getAnnotation(Api.class)!=null).findFirst();
                    if(type.isPresent())
                    {
                        api = (Api)((Class)type.get()).getAnnotation(Api.class);
                    }
                }
            }
            if (api == null || api.value().length() == 0 || (api.tags().length == 0 && api.tags()[0].length() == 0)) {
                return;
            }
            String name = api.value();
            try {
                Field field = builder.getClass().getDeclaredField("tagNames");
                field.setAccessible(true);
                Set<String> tagNames = (Set<String>) field.get(builder);
                tagNames.clear();
                tagNames.add(name);
            } catch (Exception e) {
            }
        }

        @Override
        public void apply(OperationContext context) {
            Optional<Api> optional = context.findControllerAnnotation(Api.class);
            if (!optional.isPresent()) {
                return;
            }
            Api api = optional.get();
            if (api == null || api.value().length() == 0 || (api.tags().length == 0 && api.tags()[0].length() == 0)) {
                return;
            }
            context.operationBuilder().tags(new HashSet<>(Arrays.asList(api.value())));
        }

        @Override
        public boolean supports(DocumentationType delimiter) {
            return true;
        }
    }

}
