package uk.test.crime.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import uk.test.crime.restcontroller.pojo.crime.CrimeCategoriesResponse;
import uk.test.crime.restcontroller.pojo.crime.CrimesByLocationResponse;
import uk.test.crime.restcontroller.pojo.postcode.Location;
import uk.test.crime.service.PoliceService;
import uk.test.crime.service.PostcodeService;

import javax.validation.constraints.Pattern;

import java.util.List;

import static uk.test.crime.util.PayloadValidations.DATE_REGEX;
import static uk.test.crime.util.PayloadValidations.UK_POSTCODE_REGEX;

@RestController
@Validated
public class CrimeDataController {

	private static final Logger logger = LoggerFactory.getLogger(CrimeDataController.class);
	private final PoliceService policeService;
	private final PostcodeService postcodeService;

	@Autowired
	public CrimeDataController(PoliceService policeService, PostcodeService postcodeService) {
		this.policeService = policeService;
		this.postcodeService = postcodeService;
	}

	@GetMapping(value = "/crime/categories", produces = MediaType.APPLICATION_JSON_VALUE)
	public CrimeCategoriesResponse getCrimeCategories() {
		logger.trace("getCrimeCategories() : ");

		return policeService.getCrimeCategories();
	}

	@GetMapping(value = "/crimes", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CrimesByLocationResponse> getCrimesByPostcodeAndDate(@RequestParam @Pattern(regexp = UK_POSTCODE_REGEX) String postcode,
		@RequestParam @Pattern(regexp = DATE_REGEX) String date) {
		logger.trace("getCrimesByPostcodeAndDate : {} {}", postcode, date);

		Location location = postcodeService.lookupPostcode(postcode);
		return policeService.getCrimesByLocation(location, date);
	}
}
