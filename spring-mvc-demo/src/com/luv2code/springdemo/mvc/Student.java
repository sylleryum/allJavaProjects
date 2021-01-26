package com.luv2code.springdemo.mvc;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private String firstName;
	private String lastName;
	private String country;
	private String[] OS;	
	private Map<String, String> countryList;
	//private Map<String, String> favoriteLanguage;
	//old
	private String favoriteLanguage;	

	public Student(){
		countryList = new HashMap<>();
						//(key/code, value/label)
		countryList.put("BR", "Brazil");
		countryList.put("FR", "France");
		countryList.put("DE", "Germany");
		countryList.put("US", "United States");
		
//		favoriteLanguage = new HashMap<>();
//		favoriteLanguage.put("C#", "C sharp");
//		favoriteLanguage.put("Java", "Java");
//		favoriteLanguage.put("C", "C");		
		
	}
	
	//When form is loaded, spring will call this to fill the Drop Down 
	public Map<String, String> getCountryList() {
		return countryList;
	}
	
//	public Map<String, String> getFavoriteLanguage() {
//		return favoriteLanguage;
//	}

	public String[] getOS() {
		return OS;
	}

	public void setOS(String[] oS) {
		OS = oS;
	}
	
	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
