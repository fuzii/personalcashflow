package model;

import java.util.Calendar;

public class Lead extends User{

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String status;
	private Calendar created;
	private Address address;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Address getAddress() {  
		return address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Calendar getCreated() {
		return created;
	}
	public void setCreated(Calendar created) {
		this.created = created;
	}
	public Long getId() {
		return id;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
