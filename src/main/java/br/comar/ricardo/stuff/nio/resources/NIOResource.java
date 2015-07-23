package br.comar.ricardo.stuff.nio.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ManagedAsync;
import org.springframework.beans.factory.annotation.Autowired;

import br.comar.ricardo.stuff.nio.pojo.NIOResponse;
import br.comar.ricardo.stuff.nio.service.NIOService;

@Path("/nio")
@Produces( MediaType.APPLICATION_JSON)
public class NIOResource {

	@Autowired
	NIOService service;

	@GET
	@Path("/async")
	@ManagedAsync
	public void asyncNIO(@Suspended final AsyncResponse asyncResponse,
			@QueryParam("minMs") Integer minMs,
			@QueryParam("maxMs") Integer maxMs) {
		
		int expensiveTime = service.veryExpensiveOperation(minMs, maxMs);
		NIOResponse response = new NIOResponse(expensiveTime);
		asyncResponse.resume(response);
	}

	@GET
	@Path("/sync")
	public NIOResponse syncNIO(@QueryParam("minMs") Integer minMs,
			@QueryParam("maxMs") Integer maxMs) {
		
		int expensiveTime = service.veryExpensiveOperation(minMs, maxMs);
		NIOResponse response = new NIOResponse(expensiveTime);
		return response;
	}
}