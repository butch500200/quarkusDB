package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.jpa.Customer;
import com.Joseph.quarkus.panache.repo.CustomerRepo;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class CustomerRepoTest {

	@Inject
	CustomerRepo repo;

	@Test
	@TestTransaction
	public void shouldCreateAndFindAnCustomer() throws SQLException {
		Customer customer = new Customer("name", "lastName", "test@email");
		repo.persist(customer);
		assertNotNull(customer.getId());

		customer = repo.findById(customer.getId());
		assertEquals("name", customer.getFirstName());


	}
}
