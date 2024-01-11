package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.panache.repo.ArtistRepo;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.joseph.quarkus.jdbc.Artist;

import java.util.List;

@Path("/api/artists")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ArtistResource {

	@Inject
	ArtistRepo repo;

	@GET
	public List<Artist> getAllArtist() {
		return repo.listAll();
	}

	@GET
	@Path("{id}")
	public Artist findById(@PathParam("id") Long id) {
		return repo.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	public Response persistArtist(Artist artist, @Context UriInfo uriInfo) {
		repo.persist(artist);
		//this grabs out path and adds the artist ide to the end
		UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder().path(Long.toString(artist.getId()));
		//created here is the status code
		return Response.created(uriBuilder.build()).build();
	}

	@DELETE
	@Path("{id}")
	@Transactional
	public void deleteArtist(@PathParam("id") Long id) {
		repo.deleteById(id);

	}
}
