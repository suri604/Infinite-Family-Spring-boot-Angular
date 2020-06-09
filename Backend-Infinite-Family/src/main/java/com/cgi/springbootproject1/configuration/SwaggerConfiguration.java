/**
 *
 */
package com.cgi.springbootproject1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author arun.suri
 *
 */
@EnableSwagger2
public class SwaggerConfiguration
{

    /**
     * Product api.
     *
     * @return the docket
     */
    @Bean
    public Docket productApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
                .build();
    }
}
