package com.hotel.model;

import java.sql.Date;

public class Guest {
	private int id;
	private String name;
	private String lastName;
	private Date birthdate;
	private String nationality;
	private String phone;
	private String idReservation;

	public Guest(String name, String lastName, Date birthdate, String nationality, String phone, String idReservation) {
		this.name = name;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.nationality = nationality;
		this.phone = phone;
		this.idReservation = idReservation;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdReservation() {
		return this.idReservation;
	}

	public void setIdReservation(String idReservation) {
		this.idReservation = idReservation;
	}

	@Override
	public String toString() {
		return "Guest [id=" + this.id + ", name=" + this.name + ", lastName=" + this.lastName + ", birthdate="
				+ this.birthdate + ", nationality=" + this.nationality + ", phone=" + this.phone + ", idReservation="
				+ this.idReservation + "]";
	}
}