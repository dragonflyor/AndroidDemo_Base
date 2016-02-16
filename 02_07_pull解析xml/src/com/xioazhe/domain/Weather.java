package com.xioazhe.domain;

public class Weather {
	private String city;
	private String temp;
	private String pm;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTemp() {
		return temp;
	}
	public void setTemp(String temp) {
		this.temp = temp;
	}
	public String getPm() {
		return pm;
	}
	public void setPm(String pm) {
		this.pm = pm;
	}
	
	@Override
	public String toString() {
		return "Weather [city=" + city + ", temp=" + temp + ", pm=" + pm + "]";
	}
	
	
}
