package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.panache.model.CD;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/cds")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CDResource {


	@GET
	public List<CD> getAllArtist() {
		return CD.listAll();
	}

	@GET
	@Path("{id}")
	public CD findById(@PathParam("id") Long id) {
		return (CD) CD.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}
}
