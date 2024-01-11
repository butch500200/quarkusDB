package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.jpa.Customer;
import com.Joseph.quarkus.panache.repo.CustomerRepo;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/customers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerResource {

	@Inject
	CustomerRepo repo;

	@GET
	public List<Customer> getAllCustomers() {
		return repo.listAll();
	}

	@GET
	@Path("{id}")
	public Customer findById(@PathParam("id") Long id) {
		return repo.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}
}
