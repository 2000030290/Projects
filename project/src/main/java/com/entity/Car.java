package com.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name="car")

public class Car implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
int cid;
String name;
String model;
String color;
String price;
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getModel() {
	return model;
}
public void setModel(String model) {
	this.model = model;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}

}
