package com.xiaozhe.readsms.bean;

public class MSG {
	private String body;
	private String address;
	private String date;
	private String type;
	
	public MSG(String body, String address, String date, String type) {
		this.body = body;
		this.address = address;
		this.date = date;
		this.type = type;
	}

	@Override
	public String toString() {
		return "MSG [body=" + body + ", address=" + address + ", date=" + date
				+ ", type=" + type + "]";
	}
	
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
