package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.jpa.Customer;
import com.Joseph.quarkus.panache.model.*;
import com.Joseph.quarkus.panache.repo.CustomerRepo;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.joseph.quarkus.jdbc.Artist;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PurchaseOrderRepoTest {
	@Inject
	CustomerRepo repo;

	@Test
	@TestTransaction
	public void shouldCreateAndFindAPurchaseOrderBook() {
		//creates a new book
		Book book = new Book();
		book.title = "first book";
		book.nbOfPages = 32;
		book.language = Language.GERMAN;
		//creates a new artist cause the book needs one
		Artist artist = new Artist("sam", "fun guy");
		//creates a new publisher cause the book needs one
		Publisher publisher = new Publisher("Maven");
		//Setting the relationships for book
		book.artist = artist;
		book.publisher = publisher;
		book.price = new BigDecimal(10);
		book.isbn = "13-18578";
		book.persist();

		//create orderline
		OrderLine orderLine = new OrderLine();
		orderLine.quantity = 1;
		//orderline relationships
		orderLine.item = book;
		//creating a purchase order for orderline
		PurchaseOrder purchaseOrder = new PurchaseOrder();
		//orderline relationships
		purchaseOrder.addOrderLine(orderLine);
		//now all we need is a customer
		Customer customer = new Customer("Joseph", "Cassidy", "email@.com");
		repo.persist(customer);
		//add customer and persist NOTE we have not persisted the orderline, but since that is apart of the PO, it is persisted
		purchaseOrder.customer = customer;
		purchaseOrder.persist();

		assertNotNull(purchaseOrder.id);
		assertEquals(1, purchaseOrder.orderLines.size());
		

	}
}
