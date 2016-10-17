package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@Table(name="BROKER_USER")
@DynamicUpdate(true)
@DynamicInsert(true)
@SelectBeforeUpdate
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USER_ID")
	private Long id;
	
	@Column(name="USER_NAME",nullable=false,length=40)
	private String user_name;
	
	@Column(name="PASSWORD",nullable=false,length=40)
	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="SECRET_KEY",nullable=false,length=40)
	private String secret_key;
	
	@Column(name="USER_ADDRESS",nullable=false,length=40)
	private String user_address;
	
	@Column(name="FIRST_NAME",nullable=false,length=40)
	private String first_name;
	
	@Column(name="LAST_NAME",nullable=false,length=40)
	private String last_name;
	
	@Column(name="EMAIL",nullable=false,length=40)
	private String email;
	
	@Column(name="DELETED")
	private char deleted;

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getSecret_key() {
		return secret_key;
	}

	public void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public char getDeleted() {
		return deleted;
	}

	public void setDeleted(char deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}
	
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String user_name, String secret_key, String user_address, String first_name, String last_name,
			String email, char deleted) {
		super();
		this.user_name = user_name;
		this.secret_key = secret_key;
		this.user_address = user_address;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.deleted = deleted;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", user_name=");
		builder.append(user_name);
		builder.append(", secret_key=");
		builder.append(secret_key);
		builder.append(", user_address=");
		builder.append(user_address);
		builder.append(", first_name=");
		builder.append(first_name);
		builder.append(", last_name=");
		builder.append(last_name);
		builder.append(", email=");
		builder.append(email);
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}

		
	
	
}
