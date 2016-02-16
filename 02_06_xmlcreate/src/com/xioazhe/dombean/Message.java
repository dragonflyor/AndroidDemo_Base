package com.xioazhe.dombean;


/**
 * �Զ���Ϣ���з�װ
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
	 * @param body ��Ϣ����
	 * @param date �շ�ʱ��
	 * @param address �շ�����
	 * @param type 0 ��  1 ��
	 */
	public Message(String body, String date, String address, String type) {
		super();
		this.body = body;
		this.date = date;
		this.address = address;
		this.type = type;
	}
	
	
}