package com.bupt.chatline.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private int sid;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(int sid) {
		super();
		this.sid = sid;
	}


	@Override
	public String toString() {
		return "Connection [id=" + id + ", sid=" + sid + "]";
	}
	

}
