package org.dennis.stringparser.ws;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Author:   dsu01
 * Date:     2021/2/28 10:46 上午
 * Description: The web service starter.
 */
@SpringBootApplication
public class WebServiceApp extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebServiceApp.class);
    }

    public static void main(String[] args)  {
        SpringApplication.run(WebServiceApp.class, args);
    }
}
