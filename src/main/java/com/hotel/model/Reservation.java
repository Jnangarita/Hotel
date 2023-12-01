package com.hotel.model;

import java.sql.Date;

public class Reservation {
	private int id;
	private String idReservation;
	private Date dateCheckIn;
	private Date dateCheckOut;
	private Double price;
	private String paymentMethod;

	public Reservation(String idReservation, Date dateCheckIn, Date dateCheckOut, Double price, String paymentMethod) {
		this.idReservation = idReservation;
		this.dateCheckIn = dateCheckIn;
		this.dateCheckOut = dateCheckOut;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public Reservation(int id, String idReservation, Date dateCheckIn, Date dateCheckOut, Double price,
			String paymentMethod) {
		this.id = id;
		this.idReservation = idReservation;
		this.dateCheckIn = dateCheckIn;
		this.dateCheckOut = dateCheckOut;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public Reservation(int id, Date dateCheckIn, Date dateCheckOut, Double price, String paymentMethod) {
		this.id = id;
		this.dateCheckIn = dateCheckIn;
		this.dateCheckOut = dateCheckOut;
		this.price = price;
		this.paymentMethod = paymentMethod;
	}

	public int getId() {
		return this.id;
	}

	public void setId(Integer idUser) {
		this.id = idUser;
	}

	public String getIdReservation() {
		return this.idReservation;
	}

	public Date getDateCheckIn() {
		return this.dateCheckIn;
	}

	public void setDateCheckIn(Date dateCheckIn) {
		this.dateCheckIn = dateCheckIn;
	}

	public Date getDateCheckOut() {
		return this.dateCheckOut;
	}

	public void setDateCheckOut(Date dateCheckOut) {
		this.dateCheckOut = dateCheckOut;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + this.id + ", idReservation=" + this.idReservation + ", dateCheckIn="
				+ this.dateCheckIn + ", dateCheckOut=" + this.dateCheckOut + ", price=" + this.price
				+ ", paymentMethod=" + this.paymentMethod + "]";
	}
}