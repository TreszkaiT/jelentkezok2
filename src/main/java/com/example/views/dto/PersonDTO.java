package com.example.views.dto;

import javax.persistence.ElementCollection;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.views.entity.Tanulmanyok;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * Data Transfer Object = csak adattovábbításra használatos osztály ez
 * ugyanazt csinálja, mint a Person, csak nem Entity lesz, így nem lesz szükségünk a Person.java-ban az Entity-s és JPA-s Annotációkra
 *
 * ezt az osztályt használjuk fel a PersonService-ban
 *
 * Mivel ez nem Entity, így már nincs szükésünk itt az Annotációkra
 */

public class PersonDTO {

	private Long id;
	private String FirstName;
	private String LastName;	
	private String Email;
	private String SzulDatum;
	private String Phone;

	private String Address;
	private String City;	
	private String Zip;
	private String Country;	
	
	private String KozMedia;	
	private String MessageApps;	
	private String Website;	
	
	private String Picture;	

    //private Tanulmanyok tanulmanyok;
    private Set<String> SzakmaiTap;
    private List<String> Nyelvismeret;
    private String EgyebKeszsegek;
    private String MotivaciosLevel;
	
	public PersonDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSzulDatum() {
		return SzulDatum;
	}

	public void setSzulDatum(String szulDatum) {
		SzulDatum = szulDatum;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getZip() {
		return Zip;
	}

	public void setZip(String zip) {
		Zip = zip;
	}

	public String getCountry() {
		return Country;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public String getKozMedia() {
		return KozMedia;
	}

	public void setKozMedia(String kozMedia) {
		KozMedia = kozMedia;
	}

	public String getMessageApps() {
		return MessageApps;
	}

	public void setMessageApps(String messageApps) {
		MessageApps = messageApps;
	}

	public String getWebsite() {
		return Website;
	}

	public void setWebsite(String website) {
		Website = website;
	}

	public String getPicture() {
		return Picture;
	}

	public void setPicture(String picture) {
		Picture = picture;
	}
/*
	public Tanulmanyok getTanulmanyok() {
		return tanulmanyok;
	}

	public void setTanulmanyok(Tanulmanyok tanulmanyok) {
		this.tanulmanyok = tanulmanyok;
	}
*/
	public Set<String> getSzakmaiTap() {
		return SzakmaiTap;
	}

	public void setSzakmaiTap(Set<String> szakmaiTap) {
		SzakmaiTap = szakmaiTap;
	}

	public List<String> getNyelvismeret() {
		return Nyelvismeret;
	}

	public void setNyelvismeret(List<String> nyelvismeret) {
		Nyelvismeret = nyelvismeret;
	}

	public String getEgyebKeszsegek() {
		return EgyebKeszsegek;
	}

	public void setEgyebKeszsegek(String egyebKeszsegek) {
		EgyebKeszsegek = egyebKeszsegek;
	}

	public String getMotivaciosLevel() {
		return MotivaciosLevel;
	}

	public void setMotivaciosLevel(String motivaciosLevel) {
		MotivaciosLevel = motivaciosLevel;
	}
	
	

}
