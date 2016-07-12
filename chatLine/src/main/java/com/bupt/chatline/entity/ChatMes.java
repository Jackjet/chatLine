package com.bupt.chatline.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@Entity
public class ChatMes implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4789318794528383155L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private int sid;
	
	@Column(nullable=false)
	private int did;
	
	@Column(columnDefinition = "timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP")
	private Timestamp time;
	

	@Column(nullable=false,length=1024)
	private String content;



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

	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public Timestamp getTime() {
		return time;
	}


	public void setTime(Timestamp time) {
		this.time = time;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}

	


	public ChatMes() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ChatMes(int sid, int did, String content,boolean flag) {
		super();
		this.sid = sid;
		this.did = did;
		this.content = content;
		this.time = new Timestamp(new Date().getTime());
	}


	@Override
	public String toString() {
		return "ChatMes [id=" + id + ", sid=" + sid + ", did=" + did + ", time=" + time + ", content=" + content + "]";
	}
	
}
