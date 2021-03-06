package com.xyjsoft.generator.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * 启动器
 * @author Louis
 * @date Nov 9, 2018
 */
@SpringBootApplication(scanBasePackages={"com.xyjsoft"}) 
public class XyjGeneratorApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XyjGeneratorApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(XyjGeneratorApplication.class, args);
	}
}