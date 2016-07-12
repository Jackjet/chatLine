package com.bupt.chatline.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column
	private int eid;
	

	@Column
	private int did;
	
	@Column
	private String name;
	
	@Column
	private boolean onLine;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOnLine() {
		return onLine;
	}

	public void setOnLine(boolean onLine) {
		this.onLine = onLine;
	}

	public User(int eid, String name, boolean onLine) {
		super();
		this.eid = eid;
		this.name = name;
		this.onLine = onLine;
		this.did = -1;
	}

	public User() {
		super();
		eid = -1;
		name = "";
		onLine = false;
		did = -1;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", eid=" + eid + ", did=" + did + ", name=" + name + ", onLine=" + onLine + "]";
	}

}
