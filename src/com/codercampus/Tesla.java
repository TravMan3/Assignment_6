package com.codercampus;

import java.util.Date;

public class Tesla {

	private String model;
	private Date date;
	private Integer sales;
	
	
	@Override
	public String toString() {
		return "[model=" + model + ", date=" + date + ", sales=" + sales + "]";
	}

	public Tesla(String model, Date date, Integer sales) {
		this.model = model;
		this.date = date;
		this.sales = sales;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
