package uk.test.crime.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.test.crime.config.PoliceApiConfig;
import uk.test.crime.exception.DataNotFoundException;
import uk.test.crime.restcontroller.pojo.crime.CrimeCategoriesResponse;
import uk.test.crime.restcontroller.pojo.crime.CrimeCategory;
import uk.test.crime.restcontroller.pojo.crime.CrimesByLocationResponse;
import uk.test.crime.restcontroller.pojo.postcode.Location;

import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PoliceService {
	private static final Logger logger = getLogger(PoliceService.class);
	private final PoliceApiConfig policeApiConfig;
	private final RestTemplate restTemplate;

	@Autowired
	public PoliceService(PoliceApiConfig policeApiConfig) {
		this.policeApiConfig = policeApiConfig;
		this.restTemplate = new RestTemplate();
	}

	/**
	 * @return Get List of crime categories
	 */
	public CrimeCategoriesResponse getCrimeCategories() {
		logger.debug("getCrimeCategories() ");
		String uri = policeApiConfig.getPoliceApiBase() + "/crime-categories";

		HttpEntity<Object> request = createHttpEntity();
		ResponseEntity<CrimeCategory[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, CrimeCategory[].class);
		return prepareCrimeCategoriesResponse(response.getBody());
	}

	/**
	 * @param location Location
	 * @param date     Date
	 * @return Crime info by location and date
	 */
	public List<CrimesByLocationResponse> getCrimesByLocation(Location location, String date) {
		logger.debug("getCrimesByLocation : {} {} ", location, date);

		String uri = String.format("%s/crimes-at-location?date=%s&lat=%s&lng=%s", policeApiConfig.getPoliceApiBase(),
			date, location.getLatitude(), location.getLongitude());

		HttpEntity<Object> request = createHttpEntity();
		ResponseEntity<CrimesByLocationResponse[]> response = restTemplate.exchange(uri, HttpMethod.GET, request, CrimesByLocationResponse[].class);
		validate(response.getBody());
		return Arrays.asList(response.getBody());
	}

	private CrimeCategoriesResponse prepareCrimeCategoriesResponse(CrimeCategory[] data) {
		validate(data);
		CrimeCategoriesResponse response = new CrimeCategoriesResponse();
		for (CrimeCategory crimeCategory : data) {
			response.getCategories().add(crimeCategory.getUrl());
		}
		return response;
	}

	private void validate(Object[] data) {
		if ((data == null || data.length == 0)) {
			throw new DataNotFoundException("Data is not available");
		}
	}

	private HttpEntity<Object> createHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(headers);
	}
}
