package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.panache.model.Book;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {


	@GET
	public List<Book> getAllBooks() {
		return Book.listAll();
	}

	@GET
	@Path("{id}")
	public Book findById(@PathParam("id") Long id) {
		return (Book) Book.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}
}
