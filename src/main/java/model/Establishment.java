package model;

import java.util.Calendar;
import java.util.List;
 
public class Establishment extends User{

	private Long id;
	private String name;
	private String alias;
	private String phone;
	private String email;
	private Long registerNumber;
	private int radius;
	private int rate;
	private String responsibleName;
	private String responsiblePhone;
	private String responsibleEmail;	
	private Calendar created;
	private List<Address> address; 
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Long getRegisterNumber() {
		return registerNumber;
	}
	public void setRegisterNumber(Long registerNumber) {
		this.registerNumber = registerNumber;
	}
	public Calendar getCreated() {
		return created;
	}
	public void setCreated(Calendar created) {
		this.created = created;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public String getResponsibleName() {
		return responsibleName;
	}
	public void setResponsibleName(String responsibleName) {
		this.responsibleName = responsibleName;
	}
	public String getResponsiblePhone() {
		return responsiblePhone;
	}
	public void setResponsiblePhone(String responsiblePhone) {
		this.responsiblePhone = responsiblePhone;
	}
	public String getResponsibleEmail() {
		return responsibleEmail;
	}
	public void setResponsibleEmail(String responsibleEmail) {
		this.responsibleEmail = responsibleEmail;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
