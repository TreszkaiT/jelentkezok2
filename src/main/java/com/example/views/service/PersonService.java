package com.example.views.service;

import java.util.List;
import java.util.Optional;

import com.example.views.dto.PersonDTO;

/**
 * Ez csak egy Interface, ami jó dolog,
 * mert az implementációt mögötte bármikor ki tudjuk cserélni,
 * mert csinálhatunk tetszőleges számú implementációt
 *
 * Ennek van egy konkrét implementációja (PersonServiceImpl.java)
 * -- PersonServiceImpl.java itt folytajuk
 *
 *
 * service réteg: itt van az üzeleti logika
 * szerepe: az entity és repository rétegeket tudja hívni; azaz az adatbázis rétegeit, dolgait fel tudja használni
 *
 * Interfacekre próbálunk programozni, hogy az itt definiált műveletekre az implementációt bármikor ki tudjuk cserélni
 */

public interface PersonService {

    List<PersonDTO> findAll();

    // film mentése. A létrehozott filmet szertnénk visszaadni az EndPoint felé -> MovieDTO visszatérési értéke lesz az elején
    PersonDTO create(PersonDTO personDTO);

    // film id alapján való keresése
    Optional<PersonDTO> findById(Long id);

    // film id alapján updatele
    PersonDTO update(PersonDTO personDTO);

    // delete
    void delete(Long id);
}