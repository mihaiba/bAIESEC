package com.levi9.rest.TestRest.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.levi9.rest.TestRest.model.ErrorMessage;

@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException> {

	@Override
	public Response toResponse(DataNotFoundException exception) {
		ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), Status.NOT_FOUND.getStatusCode(), "https://www.google.ro");
		return Response.status(Status.NOT_FOUND).entity(errorMessage).build();
	}

}
