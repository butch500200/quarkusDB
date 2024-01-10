package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.panache.model.Publisher;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class PublisherRepoTest {


	@Test
	@TestTransaction
	public void shouldCreateAndFindAnPublisher() throws SQLException {
		Publisher publisher = new Publisher("name");
		Publisher.persist(publisher);
		assertNotNull(publisher.id);

		publisher = Publisher.findById(publisher.id);
		assertEquals("name", publisher.name);


	}
}
