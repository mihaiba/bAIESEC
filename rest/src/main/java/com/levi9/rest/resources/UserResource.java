package com.levi9.rest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.levi9.rest.models.User;
import com.levi9.rest.services.UserService;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

	private static UserService userService = new UserService();

	@POST
	public User createUser(User user) {
		return userService.add(user);
	}

	@GET
	public List<User> getUsers() {
		return userService.getAll();
	}

	@GET
	@Path("/{userName}")
	public User getUser(@PathParam("userName") String userName) {
		return userService.get(userName);
	}

	@PUT
	@Path("/{userName}")
	public User updateUser(@PathParam("userName") String userName, User user) {
		user.setUsername(userName);
		return userService.update(user);
	}

	@DELETE
	@Path("/{userName}")
	public User deleteUser(@PathParam("userName") String userName) {
		return userService.remove(userName);
	}
}
