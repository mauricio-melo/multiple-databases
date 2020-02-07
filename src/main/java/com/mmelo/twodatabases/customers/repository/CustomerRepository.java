package com.mmelo.twodatabases.customers.repository;

import com.mmelo.twodatabases.customers.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}