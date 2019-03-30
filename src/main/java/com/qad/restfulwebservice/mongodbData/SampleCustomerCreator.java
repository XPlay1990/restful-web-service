package com.qad.restfulwebservice.mongodbData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


@Service
public class SampleCustomerCreator {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CustomerRepository customerRepository;

	public void execute() {
		customerRepository.deleteAll();
		Customer jan = new Customer();
		jan.setFirstName("Jan");
		jan.setLastName("Adamczyk");

		customerRepository.save(jan);
	}
}
