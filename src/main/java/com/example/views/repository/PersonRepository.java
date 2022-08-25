package com.example.views.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.views.entity.Person;

/**
 * ez fogja az adatbázis műveleteket elvégezni
 *
 * ez egy JPA-s repository lesz
 *
 * extends JpaRepository : ezt utána kell írni, ezt a Spring Boot- adja.
 * És ezt tudjuk kiterjeszteni. Ez egy generikus interface.
 * paraméterei: <T,ID> = <Person,Long>
 *  T : a Person repository milyen tipusu objektumok, Entity-k felett operál
 *  ID : milyen típusú az ID
 */

//az alapműveletekhez csak ennyi kell, semmi más. Csak a PersonController.java-ban be kell írni, hogy PersonRepository personRepository;  és personRepository.  után nagyon sok műveletet kapunk

//ez csak egy interface, de mikor beindítjuk a Spring Boot-sot, akkor az ennek az interfacenak az összes műveletét legenerálja,
 // és ahol ezt az interface-t használjuk, oda be fog szúrni nekünk egy implementációt, és azon keresztül tudjuk az adatbázist Query-zgetni
 // Így egy sor SQL-t se kellett megírnunk, hanem ennyi.
 public interface PersonRepository extends JpaRepository<Person, Long> {

 // itt azért saját metódusokat is tudunk definiálni, ha szeretnénk nem csak beépítetteket... a Spring Data JPA dokumentációjában utána tudunk olvasni
 // List<User> findByEmailAddressAndLastName(String emailAddress, String lastName);          // And miatt a metódus névből a Spring ki tudja generálni akár az SQL Query-t is!!! docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	 
	 //@Query("select u from User u where u.emailAddress = ?1")
	 // User findByEmailAddress(String emailAddress);
}