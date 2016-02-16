package com.xiaozhe.bean;

public class Person {
	private String _id;
	private String name;
	private String salary;
	private String phone;
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return name + "--" + salary + "--"
				+ phone;
	}
	
	public void setAll(String _id, String name, String salary, String phone)
	{
		this._id = _id;
		this.name = name;
		this.salary = salary;
		this.phone = phone;
	}
	
	
	
	
}
