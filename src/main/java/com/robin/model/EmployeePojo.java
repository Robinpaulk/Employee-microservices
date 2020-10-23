package com.robin.model;

public class EmployeePojo {
	
	private String name;
	private String lastname;
	private String address;
	private int age;
	private int salary;
	private String position;
	
	public EmployeePojo() {
		
	}
	public EmployeePojo(String name, String lastname, String address, int age, int salary, String position) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.address = address;
		this.age = age;
		this.salary = salary;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	
	
}
