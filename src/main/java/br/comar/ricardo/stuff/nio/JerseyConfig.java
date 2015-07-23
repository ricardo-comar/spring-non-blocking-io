package br.comar.ricardo.stuff.nio;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.comar.ricardo.stuff.nio.resources.NIOResource;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(NIOResource.class);
	}

}