package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.panache.model.Publisher;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.List;

@Path("/api/publishers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PublisherResource {

	@Transactional(Transactional.TxType.SUPPORTS)
	@GET
	public List<Publisher> getAllPublishers() {
		return Publisher.listAll();
	}

	@GET
	@Path("{id}")
	public Publisher findById(@PathParam("id") Long id) {
		return (Publisher) Publisher.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	public Response persistArtist(Publisher publisher, @Context UriInfo uriInfo) {
		publisher.persist();
		//this grabs out path and adds the artist ide to the end
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(publisher.id));
		//created here is the status code
		return Response.created(uriBuilder.build()).build();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public void deleteArtist(@PathParam("id") Long id) {
		Publisher.deleteById(id);

	}

}
