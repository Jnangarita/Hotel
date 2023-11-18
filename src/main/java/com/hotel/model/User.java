package com.hotel.model;

public class User {

	private Integer idUser;
	private String userName;
	private String password;

	public User() {}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Integer getIdUser() {
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [idUser=" + this.idUser + ", userName=" + this.userName + ", password=" + this.password + "]";
	}
}