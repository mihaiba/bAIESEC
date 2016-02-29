package com.levi9.rest.TestRest.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/demo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class DemoResource {

	@GET
	@Path("/annotations")
	public String getParamsAnnotations(@MatrixParam("param") String param,
			@HeaderParam("customHeaderValue") String customHeaderValue, @CookieParam("cookie") String cookie) {
		return "Matrix param: " + param + " customeHeaderValue: " + customHeaderValue + " cookie: " + cookie;
	}

	@GET
	@Path("/context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		return "Path: " + uriInfo.getAbsolutePath().toString() + " cookies: " + headers.getCookies();
	}

	@GET
	@Path("/query")
	public String getQueryParams(@QueryParam("q") String query) {
		return "Query is: " + query;
	}
}
