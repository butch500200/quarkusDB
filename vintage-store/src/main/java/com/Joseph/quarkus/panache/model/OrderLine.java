package com.Joseph.quarkus.panache.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "t_purchase_order_line")
public class OrderLine extends PanacheEntity {

	@ManyToOne
	@JoinColumn(name = "item_fk")
	public Item item;

	@Column(nullable = false)
	public Integer quantity;

	@ManyToOne
	@JoinColumn(name = "purchase_order_fk")
	public PurchaseOrder purchaseOrder;

	@Column(name = "create_date")
	public Instant createDate = Instant.now();


}
