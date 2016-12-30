package model;

import java.util.Calendar;

public class Address {
  
	private Long id;
	private Long accountId;
	private Long establishmentId;
	private String zipCode;
	private String street;
	private String city;
	private String state;
	private int number; 
	private String premise;
	private String country;
	private Double latitude;
	private Double longitude;
	private Calendar created;
	
	
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Long getEstablishmentId() {
		return establishmentId;
	}
	public void setEstablishmentId(Long establishmentId) {
		this.establishmentId = establishmentId;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Calendar getCreated() {
		return created;
	}
	public void setCreated(Calendar created) {
		this.created = created;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getPremise() {
		return premise;
	}
	public void setPremise(String premise) {
		this.premise = premise;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Long getId() {
		return id;
	}
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	             
}
