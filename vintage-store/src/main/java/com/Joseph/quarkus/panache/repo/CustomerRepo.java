package com.Joseph.quarkus.panache.repo;

import com.Joseph.quarkus.jpa.Customer;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerRepo implements PanacheRepository<Customer> {
}
