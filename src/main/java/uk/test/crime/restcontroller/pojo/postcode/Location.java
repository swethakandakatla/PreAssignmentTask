package uk.test.crime.restcontroller.pojo.postcode;

public class Location {
	private double latitude;
	private double longitude;
	private String postcode;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Override
	public String toString() {
		return "Location{" +
			"latitude=" + latitude +
			", longitude=" + longitude +
			", postcode='" + postcode + '\'' +
			'}';
	}
}
