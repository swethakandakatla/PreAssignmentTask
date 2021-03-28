package uk.test.crime.restcontroller.pojo.crime;

import uk.test.crime.restcontroller.pojo.postcode.Location;

public class CrimesByLocationResponse {
	private String category;
	private Location location;
	private String context;
	private Object outcome_status;
	private String month ;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	public Object getOutcome_status() {
		return outcome_status;
	}

	public void setOutcome_status(Object outcome_status) {
		this.outcome_status = outcome_status;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "CrimesByLocationResponse{" +
			"category='" + category + '\'' +
			", location=" + location +
			", context='" + context + '\'' +
			", outcome_status=" + outcome_status +
			", month='" + month + '\'' +
			'}';
	}
}
