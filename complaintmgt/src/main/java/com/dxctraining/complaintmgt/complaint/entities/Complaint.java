package com.dxctraining.complaintmgt.complaint.entities;

import javax.persistence.*;

@Entity
@Table(name = "complaints")
public class Complaint {

	@Id
	@GeneratedValue
	private int id;

	private String description;

	private Integer consumerId;

	public Complaint() {

	}

	public Complaint(String description, int consumerId) {
		this.description = description;
		this.consumerId = consumerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getConsumerId() {
		return consumerId;
	}

	public void setConsumerId(Integer consumerId) {
		this.consumerId = consumerId;
	}

	@Override
	public boolean equals(Object arg) {
		if (this == arg) {
			return true;
		}
		if (arg == null || getClass() != arg.getClass()) {
			return false;
		}
		Complaint that = (Complaint) arg;
		boolean isequals = this.id == that.id;
		return isequals;

	}

	@Override
	public int hashCode() {
		return id;
	}
}
