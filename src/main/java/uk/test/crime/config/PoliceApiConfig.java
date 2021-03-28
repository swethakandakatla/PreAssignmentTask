package uk.test.crime.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("services.police-api-config")
public class PoliceApiConfig {
	private String policeApiBase;

	public String getPoliceApiBase() {
		return policeApiBase;
	}

	public void setPoliceApiBase(String policeApiBase) {
		this.policeApiBase = policeApiBase;
	}
}
