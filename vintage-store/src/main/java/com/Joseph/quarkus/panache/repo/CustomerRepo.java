package com.Joseph.quarkus.panache.repo;

import com.Joseph.quarkus.jpa.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class CustomerRepo implements PanacheRepository<Customer> {

	public List<Customer> listAllDans() {
		return list("firstName='dan'", Sort.by("lastName"));
	}
}
