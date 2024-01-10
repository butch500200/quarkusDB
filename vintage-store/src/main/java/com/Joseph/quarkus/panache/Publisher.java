package com.Joseph.quarkus.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.Instant;


/**
 * Example JPA entity defined as a Panache Entity.
 * An ID field of Long type is provided, if you want to define your own ID field extends <code>PanacheEntityBase</code> instead.
 * <p>
 * This uses the active record pattern, you can also use the repository pattern instead:
 * .
 * <p>
 * Usage (more example on the documentation)
 * <p>
 * {@code
 * public void doSomething() {
 * MyEntity entity1 = new MyEntity();
 * entity1.field = "field-1";
 * entity1.persist();
 * <p>
 * List<MyEntity> entities = MyEntity.listAll();
 * }
 * }
 */
@Entity
public class Publisher extends PanacheEntity {
	public String name;
	public Instant createdDate = Instant.now();

	public Publisher() {
	}

	public Publisher(String name) {
		this.name = name;
	}
}
