package model;

import java.util.Calendar;
import java.util.List;

public class Account extends User{
  
	private Long id;
	private String name;
	private String email;
	private String phone;
	private Calendar created;
	private List<Address> address;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void addAddress(Address address) {
		this.address.add(address);
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
	
}
