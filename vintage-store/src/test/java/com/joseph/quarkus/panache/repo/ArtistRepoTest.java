package com.joseph.quarkus.panache.repo;

import com.Joseph.quarkus.panache.repo.ArtistRepo;
import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.joseph.quarkus.jdbc.Artist;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
public class ArtistRepoTest {
	@Inject
	ArtistRepo repo;


	@Test
	@TestTransaction
	public void shouldCreateAndFindAnArtist() throws SQLException {
		Artist artist = new Artist("name", "bio");
		repo.persist(artist);
		assertNotNull(artist.getId());

		artist = repo.findById(artist.getId());
		assertEquals("name", artist.getName());


	}


}
