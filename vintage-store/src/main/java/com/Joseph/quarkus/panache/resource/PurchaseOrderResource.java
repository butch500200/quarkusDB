package com.Joseph.quarkus.panache.resource;

import com.Joseph.quarkus.panache.model.Publisher;
import com.Joseph.quarkus.panache.model.PurchaseOrder;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/api/pos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class PurchaseOrderResource {


	@GET
	public List<PurchaseOrder> getAllPurchaseOrders() {
		return PurchaseOrder.listAll();
	}

	@GET
	@Path("{id}")
	public PurchaseOrder findById(@PathParam("id") Long id) {
		return (PurchaseOrder) PurchaseOrder.findByIdOptional(id).orElseThrow(NotFoundException::new);
	}

	@POST
	@Transactional
	public Publisher persistPublisher(Publisher publisher) {
		return null;
	}
}
