package uk.test.crime.util;

public final class PayloadValidations {

	//Allows yyyy-MM
	public static final String DATE_REGEX = "^[0-9]{4}-(0[1-9]|1[012])$";

	//UK Postcode validation regular expression
	public static final String UK_POSTCODE_REGEX = "([Gg][Ii][Rr] 0[Aa]{2})|((([A-Za-z][0-9]{1,2})|(([A-Za-z][A-Ha-hJ-Yj-y][0-9]{1,2})|("
		+ "([A-Za-z][0-9][A-Za-z])|([A-Za-z][A-Ha-hJ-Yj-y][0-9][A-Za-z]?))))\\s?[0-9][A-Za-z]{2})";

	//avoid instance creation
	private PayloadValidations() {

	}
}
