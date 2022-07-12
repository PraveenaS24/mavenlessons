package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment implements java.io.Serializable{
	@Id
	@Column(name = "APP_ID")
	private int id;
	@Column(name = "APP_DATE")
	private Date appointdate;
	@Column(name = "DOC_ID")
	private int did;
	@Column(name = "PATIENT_NAME")
	private String patname;
	@Column(name = "FEES_COLLECTED")
	private float fees;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOC_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Doctor doctor;

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppointdate() {
		return appointdate;
	}

	public void setAppointdate(Date appointdate) {
		this.appointdate = appointdate;
	}

	public int getDid() {
		return did;
	}

	public void setDid(int did) {
		this.did = did;
	}

	public String getPatname() {
		return patname;
	}

	public void setPatname(String patname) {
		this.patname = patname;
	}

	public float getFees() {
		return fees;
	}

	public void setFees(float fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %f", id, appointdate, patname, fees);
	}
}
