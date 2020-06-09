package com.cgi.springbootproject1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class SpringBootProject1Application
{

    public static void main(final String[] args)
    {
        SpringApplication.run(SpringBootProject1Application.class, args);
    }

}
