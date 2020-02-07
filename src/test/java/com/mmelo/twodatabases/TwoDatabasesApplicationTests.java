package com.mmelo.twodatabases;

import com.mmelo.twodatabases.customers.domain.Customer;
import com.mmelo.twodatabases.customers.repository.CustomerRepository;
import com.mmelo.twodatabases.users.domain.User;
import com.mmelo.twodatabases.users.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TwoDatabasesApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void contextLoads() {
		userRepository.findAll();
	}

}
