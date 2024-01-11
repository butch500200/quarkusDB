package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.jpa.Customer;
import com.Joseph.quarkus.panache.repo.CustomerRepo;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class CustomerRepoTest {

	@Inject
	CustomerRepo repo;

	@Test
	@TestTransaction
	public void shouldCreateAndFindAnCustomer() throws SQLException {
		Customer customer = new Customer("dan", "lastName", "test@email");
		repo.persist(customer);
		assertNotNull(customer.getId());
		assertTrue(repo.listAllDans().size() <= repo.listAll().size());

		customer = repo.findById(customer.getId());
		assertEquals("dan", customer.getFirstName());


	}
}
