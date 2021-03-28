package uk.test.crime.restcontroller.pojo.crime;

import java.util.ArrayList;
import java.util.List;

public class CrimeCategoriesResponse {
	private List<String> categories = new ArrayList<>();
	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "CrimeCategoriesResponse{" +
			"categories=" + categories +
			'}';
	}
}
