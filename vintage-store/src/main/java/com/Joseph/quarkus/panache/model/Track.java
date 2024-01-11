package com.Joseph.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "t_tracks")
public class Track extends PanacheEntity {
	@Column(nullable = false)
	public String title;
	@Column(nullable = false)
	public Duration duration;
	@Column(name = "created_date")
	public Instant createdDate = Instant.now();
	@ManyToOne
	@JoinColumn(name = "cd_fk")
	@JsonbTransient
	public CD cd;

}
