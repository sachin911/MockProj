package com.sapient.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee implements Serializable {
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private int id;
	private String name;
	private int age;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	
	public int getId() {
		return id;
	}

	@XmlElement
	public String getName() {
		return name;
	}

	@XmlElement
	public int getAge() {
		return age;
	}

	public String toString() {
		return "Employee: [" + name + ", ID: " + id + ", AGE " + age + "]";
	}
}
