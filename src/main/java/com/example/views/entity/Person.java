package com.example.views.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;

//import javax.annotation.Generated;

//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.helger.commons.annotation.PrivateAPI;

@Entity
public class Person {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)             // azt mondja meg, hogy hogyan generálódjon egy ilyen Entitás Id-ja. Megmondjuk, hogy milyen stratégiát használjon ehhez. Auto=AutoIncrement lesz
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

	// magától a Set Stringek halmazát nem tudja betenni az adatbázisba, sőt Exceptionnal el is száll az alkalmazás
    // így ezt az Annotációt rá kell tenni. Azaz csinál hozzá egy külön kis táblát, és abból lesznek hozzácsatolva az egyes műfajok a Movies tábla adott filmjéhez
    //@ElementCollection
	//@NotNull
	//@ManyToOne
    //private Tanulmanyok tanulmanyok;
    @ElementCollection
    private Set<String> SzakmaiTap;
    @ElementCollection
    private List<String> Nyelvismeret; //Set<String> Nyelvismeret; //
    private String EgyebKeszsegek;
    private String MotivaciosLevel;
		
	public Person() {}

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
