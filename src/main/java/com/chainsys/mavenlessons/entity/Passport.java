package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Passports")
public class Passport {
	@Id
	@Column(name = "PASSPORT_NUMBER")
	private int id;
	@Column(name = "PASSPORT_DATE")
	private Date date;
	@Column(name = "USER_NO")
	private int userId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@OneToOne
	@JoinColumn(name ="USER_NO", nullable = false, insertable = false, updatable = false)		
	@JsonIgnore
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
/*PASSPORT_NUMBER NUMBER(4) NOT NULL PRIMARY KEY,
PASSPORT_DATE DATE NOT NULL ,
USER_NO NUMBER(6) NOT NULL*/