package com.Joseph.quarkus.panache.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;
import org.joseph.quarkus.jdbc.Artist;

import java.util.List;

@ApplicationScoped
public class ArtistRepo implements PanacheRepository<Artist> {

	public List<Artist> listAllArtistsSorted() {
		return listAll(Sort.by("name"));
	}
}
