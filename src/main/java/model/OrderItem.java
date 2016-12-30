package model;

import java.util.Currency;
import java.util.Date;

public class OrderItem {

	private Long id;
	private Product product;
	private String dayOfWeek;
	private Date deliveryTime;
	private String unit;
	private Integer quantity;
	private Currency price;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public Date getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(Date deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Currency getPrice() {
		return price;
	}
	public void setPrice(Currency price) {
		this.price = price;
	}	
	
}
