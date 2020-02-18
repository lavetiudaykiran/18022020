package com.petperr.model;

public class Pet {
private int id;
private String petname;
private int petage;
private String petplace;
private int petownerid;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPetname() {
	return petname;
}
public void setPetname(String petname) {
	this.petname = petname;
}
public int getPetage() {
	return petage;
}
public void setPetage(int petage) {
	this.petage = petage;
}
public String getPetplace() {
	return petplace;
}
public void setPetplace(String petplace) {
	this.petplace = petplace;
}
public int getPetownerid() {
	return petownerid;
}
public void setPetownerid(int petownerid) {
	this.petownerid = petownerid;
}

}
