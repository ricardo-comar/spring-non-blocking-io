package br.comar.ricardo.stuff.nio;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class SpringNonBlockingIoApplication extends SpringBootServletInitializer {

    @Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringNonBlockingIoApplication.class);
	}

	public static void main(String[] args) {
		new SpringNonBlockingIoApplication().configure(
				new SpringApplicationBuilder(SpringNonBlockingIoApplication.class)).run(args);
	}
}
