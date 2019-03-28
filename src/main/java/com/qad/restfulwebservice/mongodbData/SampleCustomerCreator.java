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


		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("git.properties");
		Properties gitProperties = readFromInputStream(resourceAsStream);
		try {
			resourceAsStream.close();
		} catch (IOException e) {
		}

		String branch = gitProperties.getProperty("git.branch");
		String buildVersion = gitProperties.getProperty("git.build.version");
		String commitTag = gitProperties.getProperty("git.commit.id.describe-short");
		logger.error(branch + " @ " + buildVersion + " Commit:" + commitTag);
	}


	private Properties readFromInputStream(InputStream inputStream) {
		Properties gitProperties = new Properties();
		try {
			gitProperties.load(inputStream);
		} catch (IOException e) {
			String output = "Version information could not be retrieved!";
			logger.error(output);
		}
		return gitProperties;
	}
}
