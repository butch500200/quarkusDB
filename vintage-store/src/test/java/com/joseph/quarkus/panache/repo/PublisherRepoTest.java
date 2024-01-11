package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.panache.model.Publisher;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
public class PublisherRepoTest {


	@Test
	@TestTransaction
	public void shouldCreateAndFindAnPublisher() throws SQLException {
		long count = Publisher.count();
		int listAll = Publisher.listAll().size();
		assertEquals(count, listAll);

		Publisher publisher = new Publisher("name");
		Publisher.persist(publisher);
		assertNotNull(publisher.id);

		publisher = Publisher.findById(publisher.id);
		publisher = Publisher.findByName(publisher.name).orElseThrow(EntityNotFoundException::new);
		assertEquals("name", publisher.name);
		assertEquals(count + 1, Publisher.count());

		assertTrue(Publisher.containName("name").size() >= 1);

		publisher.delete();
		assertEquals(count, Publisher.count());


	}
}
