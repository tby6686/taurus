package cn.com.taurus.framework.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.annotations.Api;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
import springfox.documentation.spring.web.plugins.Docket;
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

}
