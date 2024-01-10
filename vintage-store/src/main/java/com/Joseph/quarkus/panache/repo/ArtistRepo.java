package com.Joseph.quarkus.panache.repo;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.joseph.quarkus.jdbc.Artist;

@ApplicationScoped
public class ArtistRepo implements PanacheRepository<Artist> {
}
