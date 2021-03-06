package com.xioazhe.dombean;


/**
 * 对短信息进行封装
 * @author zhe
 *
 */
public class Message {
	private String body;
	private String date;
	private String address;
	private String type;
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * 
	 * @param body 信息内容
	 * @param date 收发时间
	 * @param address 收发号码
	 * @param type 0 收  1 发
	 */
	public Message(String body, String date, String address, String type) {
		super();
		this.body = body;
		this.date = date;
		this.address = address;
		this.type = type;
	}
	
	
}
