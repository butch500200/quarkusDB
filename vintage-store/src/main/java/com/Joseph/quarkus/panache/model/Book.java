package com.Joseph.quarkus.panache.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Book extends Item {
	@Column(length = 100)
	public String isbn;
	@Column(name = "nb_of_pages")
	public Integer nbOfPages;
	@Enumerated(EnumType.STRING)
	public Language language;
	@Column(name = "publication_date")
	public LocalDate publicationDate;
	@ManyToOne
	@JoinColumn(name = "publisher_fk")
	public Publisher publisher;


}
