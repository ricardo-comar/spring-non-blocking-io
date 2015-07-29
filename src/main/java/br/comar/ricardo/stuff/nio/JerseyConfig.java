package br.comar.ricardo.stuff.nio;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.comar.ricardo.stuff.nio.resources.NIOResource;

@Configuration
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(NIOResource.class);
	}

}