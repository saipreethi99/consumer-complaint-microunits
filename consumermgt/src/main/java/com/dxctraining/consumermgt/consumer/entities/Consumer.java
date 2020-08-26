package com.dxctraining.consumermgt.consumer.entities;

import javax.persistence.*;

@Table(name = "consumers")
@Entity
public class Consumer {

    @Id
    @GeneratedValue
    private int id;

    private String name;

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
    
    public Consumer(String name) {
		this.name = name;
	}
	
	public Consumer() {
	}

    @Override
    public boolean equals(Object arg) {
        if (this == arg) {
        	return true;
        }
        if (arg == null || getClass() != arg.getClass()) {
        	return false;
        }
        Consumer that = (Consumer) arg;
        boolean isequals = this.id == that.id;
		return isequals;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
