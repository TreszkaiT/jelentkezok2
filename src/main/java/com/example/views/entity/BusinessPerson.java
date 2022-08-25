package com.example.views.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//tag::snippet[]
@Entity
public class BusinessPerson {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)             // azt mondja meg, hogy hogyan generálódjon egy ilyen Entitás Id-ja. Megmondjuk, hogy milyen stratégiát használjon ehhez. Auto=AutoIncrement lesz
	private Long id;	
 String name;
 String title;
 int age;

 public BusinessPerson() {}

 void setName(String name) {this.name = name;}
 String getName() {return name;}

 void setTitle(String title) {this.title = title;}
 String getTitle() {return title;}

 void setAge(int age) {this.age = age;}
 int getAge() {return age;}
}
//end::snippet[]
