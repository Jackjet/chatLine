package com.bupt.chatline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Salesman {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false,unique = true)
	private String name;

	@Column(nullable = false)
	private String password;
	@Column
	private String phone;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Salesman() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Salesman(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Salesman(String name, String password, String phone) {
		super();
		this.name = name;
		this.password = password;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Salesman [id=" + id + ", name=" + name + ", password=" + password + ", phone=" + phone + "]";
	}

}
