package uk.test.crime.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("services.postcode-api-config")
public class PostcodeApiConfig {
	private String postcodeApiBase;

	public String getPostcodeApiBase() {
		return postcodeApiBase;
	}

	public void setPostcodeApiBase(String postcodeApiBase) {
		this.postcodeApiBase = postcodeApiBase;
	}
}
