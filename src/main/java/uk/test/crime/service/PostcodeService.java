package uk.test.crime.service;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import uk.test.crime.config.PostcodeApiConfig;
import uk.test.crime.exception.DataNotFoundException;
import uk.test.crime.restcontroller.pojo.postcode.Location;
import uk.test.crime.restcontroller.pojo.postcode.PostcodeResponse;

import static org.slf4j.LoggerFactory.getLogger;

@Service
public class PostcodeService {
	private static final Logger logger = getLogger(PostcodeService.class);
	private final PostcodeApiConfig postcodeApiConfig;
	private final RestTemplate restTemplate;

	@Autowired
	public PostcodeService(PostcodeApiConfig postcodeApiConfig) {
		this.postcodeApiConfig = postcodeApiConfig;
		this.restTemplate = new RestTemplate();
	}

	public Location lookupPostcode(String postcode) {
		logger.debug("lookupPostcode : {}", postcode);
		String uri = postcodeApiConfig.getPostcodeApiBase() + "/postcodes/" + postcode;
		HttpEntity<Object> request = createHttpEntity();
		ResponseEntity<PostcodeResponse> response = restTemplate.exchange(uri, HttpMethod.GET, request, PostcodeResponse.class);
		if(response.getBody()==null) {
			throw new DataNotFoundException("Postcode is not Found");
		}
		return response.getBody().getResult();
	}

	private HttpEntity<Object> createHttpEntity() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<>(headers);
	}
}

