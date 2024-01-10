package com.Joseph.quarkus.panache.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class CD extends Item {
	@Column(name = "music_Company")
	public String musicCompany;
	@Column(length = 15)
	public String genre;
	@OneToMany(mappedBy = "cd")
	public List<Track> tracks;
}
