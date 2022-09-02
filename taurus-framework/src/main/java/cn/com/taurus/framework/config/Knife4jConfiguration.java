package cn.com.taurus.framework.config;

import static springfox.documentation.schema.Annotations.findPropertyAnnotation;
import static springfox.documentation.swagger.schema.ApiModelProperties.findApiModePropertyAnnotation;

import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Optional;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import java.lang.reflect.Field;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.common.SwaggerPluginSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author tby
 * @description
 * @date 2022-08-22 17:30
 * http://localhost:8088/api/doc.html
 */
@Slf4j
@Configuration
@EnableSwagger2
@EnableKnife4j
public class Knife4jConfiguration {

    /**
     * Swagger忽略的参数类型
     */
    private Class<?>[] ignoredParameterTypes = new Class[]{
        ServletRequest.class,
        ServletResponse.class,
        HttpServletRequest.class,
        HttpServletResponse.class,
        HttpSession.class,
        ApiIgnore.class
    };

    @Bean
    public Docket createRestApi() {
        ApiSelectorBuilder apiSelectorBuilder = new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .select();
        // 默认扫描类上有@Api注解的类
        apiSelectorBuilder.apis(RequestHandlerSelectors.withClassAnnotation(Api.class));

        Docket docket = apiSelectorBuilder.paths(PathSelectors.any())
            .build()
            .enable(true)
            .ignoredParameterTypes(ignoredParameterTypes);
        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .description("spirng boot taurus apis")
            .contact(new Contact("tby", "https://github.com/tby6686/taurus.git", "814620421@qq.com"))
            .version("v1.1.0")
            .title("spirng-boot-taurus")
            .build();
    }



    /**
     * 按照类中字段顺序显示
     */
    @Component
    public static class ApiModelPropertyBuilderPlugin implements ModelPropertyBuilderPlugin {

        @Override
        public void apply(ModelPropertyContext context) {
            try {
                Optional<BeanPropertyDefinition> beanPropertyDefinitionOptional = context.getBeanPropertyDefinition();

                Optional<ApiModelProperty> annotation = Optional.absent();
                if (context.getAnnotatedElement().isPresent()) {
                    annotation = annotation.or(findApiModePropertyAnnotation(context.getAnnotatedElement().get()));
                }
                if (context.getBeanPropertyDefinition().isPresent()) {
                    annotation = annotation.or(findPropertyAnnotation(context.getBeanPropertyDefinition().get(), ApiModelProperty.class));
                }
                if (beanPropertyDefinitionOptional.isPresent()) {
                    BeanPropertyDefinition beanPropertyDefinition = beanPropertyDefinitionOptional.get();
                    if (annotation.isPresent() && annotation.get().position() != 0) {
                        return;
                    }
                    AnnotatedField annotatedField = beanPropertyDefinition.getField();
                    if (annotatedField == null) {
                        return;
                    }
                    Class<?> clazz = annotatedField.getDeclaringClass();
                    Field[] fields = clazz.getDeclaredFields();
                    // 获取当前字段对象
                    Field field = clazz.getDeclaredField(annotatedField.getName());
                    boolean required = false;
                    // 获取字段注解
                    NotNull notNull = field.getDeclaredAnnotation(NotNull.class);
                    NotBlank notBlank = field.getDeclaredAnnotation(NotBlank.class);
                    if (notNull != null || notBlank != null) {
                        required = true;
                    }
                    int position = ArrayUtils.indexOf(fields, field);
                    if (position != -1) {
                        context.getBuilder().position(position).required(required);
                    }
                }
            } catch (Exception exception) {
                log.error("Swagger ApiModelProperty预处理异常", exception);
            }
        }

        @Override
        public boolean supports(DocumentationType delimiter) {
            return SwaggerPluginSupport.pluginDoesApply(delimiter);
        }
    }

}
