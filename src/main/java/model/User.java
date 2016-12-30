package model;

import java.util.Calendar;
  
public class User {

	protected Long userId;
	protected String userLogin;
	protected char[] userPassword;
	protected Calendar userCreated;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public char[] getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(char[] userPassword) {
		this.userPassword = userPassword;
	}
	public Calendar getUserCreated() {
		return userCreated;
	}
	public void setUserCreated(Calendar userCreated) {
		this.userCreated = userCreated;
	}
	
	
	
}
