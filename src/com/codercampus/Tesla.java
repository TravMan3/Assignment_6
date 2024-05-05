package com.codercampus;

public class Tesla {

	private String date;
	private Integer sales;
	
	public Tesla(String date, Integer totalSales) {
		this.date = date;
		this.sales = totalSales;
	}
	
	public Tesla() {
		super();
		this.date = " ";
		this.sales = 0;
	}

	@Override
	public String toString() {
		return "Tesla [date=" + date + ", sales=" + sales + "]";
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getSales() {
		return sales;
	}

	public void setSales(Integer sales) {
		this.sales = sales;
	}

}
