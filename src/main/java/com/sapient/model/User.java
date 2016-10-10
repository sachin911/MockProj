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
	
	@Column(name="SECRET_KEY",nullable=false,length=40)
	private String secret_key;
	
	@Column(name="USER_ADDRESS",nullable=false,length=40)
	private String user_address;
	
	@Column(name="DELETED",nullable=false,length=40)
	private boolean deleted;

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

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Long getId() {
		return id;
	}
	
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String user_name, String secret_key, String user_address, boolean deleted) {
		super();
		this.user_name = user_name;
		this.secret_key = secret_key;
		this.user_address = user_address;
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
		builder.append(", deleted=");
		builder.append(deleted);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
