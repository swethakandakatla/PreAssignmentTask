package uk.test.crime.restcontroller.pojo.crime;

public class CrimeCategory {
	private String url;
	private String name;
	
  /*setters and getters for the url and name of crime Categories*/
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CrimeCategory{" +
			"url='" + url + '\'' +
			", name='" + name + '\'' +
			'}';
	}
}
