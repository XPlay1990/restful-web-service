package com.qad.restfulwebservice.versionInfos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VersionController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/version")
	public GitVersion getVersion() {
		InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("git.properties");
		Properties gitProperties = readFromInputStream(resourceAsStream);
		try {
			resourceAsStream.close();
		} catch (IOException e) {
		}

		String branch = gitProperties.getProperty("git.branch");
		String buildVersion = gitProperties.getProperty("git.build.version");
		String commitTag = gitProperties.getProperty("git.commit.id.describe-short");
		logger.info("Version delivered");
		return (new GitVersion(branch + " @ " + buildVersion + " Commit:" + commitTag));
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
