package uk.test.crime.restcontroller.pojo.postcode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostcodeResponse {
	private int status;
	private Location result;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Location getResult() {
		return result;
	}

	public void setResult(Location result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "PostcodeResponse{" +
			"status=" + status +
			", result=" + result +
			'}';
	}
}
