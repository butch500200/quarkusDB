package com.Joseph.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "t_purchase_order_lines")
public class OrderLine extends PanacheEntity {

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item_fk")
	public Item item;

	@Column(nullable = false)
	public Integer quantity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "purchase_order_fk")
	@JsonbTransient
	public PurchaseOrder purchaseOrder;

	@Column(name = "created_date")
	public Instant createDate = Instant.now();


}
