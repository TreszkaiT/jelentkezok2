package com.example.views.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.exception.PersonNotFoundException;
import com.example.views.dto.PersonDTO;
import com.example.views.entity.Person;
import com.example.views.repository.PersonRepository;
import com.example.views.service.PersonService;
import org.modelmapper.ModelMapper;

import org.dozer.DozerBeanMapper;

//@Component
@Service
public class PersonServiceImplement implements PersonService {

	private final PersonRepository personRepository;	
	//private final ModelMapper modelMapper;
    /*@Bean
    public ModelMapper modelMapper() {
       ModelMapper modelMapper = new ModelMapper();
       return modelMapper;
    }
	@Bean
	public ModelMapper modelMapper() {
	  return new ModelMapper();
	}*/
	private final ModelMapper modelMapper;
	//private final Mapper modelMapper;
	DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
    
    public PersonServiceImplement(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;  // mivel ezt kívülről kaptuk, a dependency-ből, így valahol léteznie kellene belőle egy Bean-nek, hogy a Spring le tudja példányosítani ezt az osztályt
                                            // ehhez a modelMapper oszályhoz nem tudunk odamenni, és beleírni az Annotációt, mert ezt kívűlről kaptuk, hanem van egy másik lehetőség is, hogy Bean-eket definiáljunk
                                            // például java config által -> így ehhez egy configuration packaget kell csinálni

        // ha futtatni akarjuk, akkor hogy az adatbázisnak legyen valami tartalma, így ezt ide kell másolni:
        Person person1 = new Person(); // hogy legyen példaadat is
        person1.setFirstName("Star Wars");
        Person person2 = new Person();
        person2.setFirstName("Terminator");

        personRepository.save(person1);   // lementi az adatbázisba
        personRepository.save(person2);


    }    
	
	@Override
	public List<PersonDTO> findAll() {
        List<Person> personList = personRepository.findAll();      // az összes filmet felszedjük a movieRepositoryval, ami az adatbázisban van, és elmentük ezt egy Listába
        // ezt közvetlenül még nem tudom visszaadni, mert ő egy Movie típusú lista, és nekem egy MovieDTO kell
		// hogy ne kelljen átliterálni a movieList-en, és mindegyik esetében csinálik egy új movieDTO-t és át set-telgetem a Movie-ba, ezért húzta be a dependency-be a modelmapper függőséget, mely automatikusan tud konvertálni egyik osztályból a másikba
		// most nálunk könnyű ez, mert mindkét osztályban ugyanazok a fieldek (id, title, ....)  ;;; de bonyolultabb esetekben célszerű saját logikát írni rá ; így fent fel kell venni függőségként, majd Alt+Enter-el felveszem a konstruktorba ezt is
		// majd
		
		// vagy végigmegyek for ciklussal a List-án, vagy inkább egyszerűbben csináljuk Stream-el, így veszem a java streamAPI-ját, és a Movie-kat beleteszem a stream-be, és az ősszes elemre végrehajtok egy map-pelést; azaz átlakítom mássá az elemeket
		return personList.stream()
				.map(person ->  modelMapper.map(person, PersonDTO.class)) //dozerBeanMapper.map(person, PersonDTO.class))           // movie adatot MovieDTO.class osztályba akarom alakítani
				.collect(Collectors.toList());                                  // és ezek után ezzel a művelettel begyűjtöm egy listába. Majd gyakorlatilag ezeket vissza is tudom már így adni a return-t eléírva
		
		//return null;
	}

	@Override
	public PersonDTO create(PersonDTO personDTO) {
        Person personToSave = modelMapper.map(personDTO, Person.class);             // ez átalakítja a MovieDTO-t Movie-ra, azaz Entity-vé
        personToSave.setId(null);                                                // védelem, hogy ne írjuk felül a már meglévő is-jű elemeket a DB-ban. Null-nál ugyanis új id-val generálja az új rekordokat a Spring
        Person savedPerson = personRepository.save(personToSave);                   // ez menti el az adatbázisba, vagy updateli is, ha már van olyan id-jű; és ez vissza is adja azt az Enity-t amit elmentett; ez kell, mert a JPA mentés során automatikusan generál neki egy ID-t
        return modelMapper.map(savedPerson, PersonDTO.class);                     // és a kapott objektumot visszaalakítom MovieDTO-vá
	}

	@Override
	public Optional<PersonDTO> findById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);           // Optional<Movie> :  a Move Entity-t becsomagolja egy Optional generikus metódusba. A nullkezeléssel kapcsolatos dolgokat meg tudunk oldani (if(null)-al így már nem kell fogalalkozni)... keresékeknél használható, hoy megtaláltunk-e valamit vagy sem
        return optionalPerson.map(person -> modelMapper.map(person, PersonDTO.class));                                    // Movie Entity -> MovieDTO  azaz, optionalMovie.map(movie -> ha itt szerepel egy movie, ami nem null, azaz nem üres, akkor alakítsd át: modelMapper.map(movie, MovieDTO.class)   
	}

	@Override
	public PersonDTO update(PersonDTO personDTO) {
        Long id = personDTO.getId();                                             // létezik-e már ilyen id, mert ha nem, akkor új sort szúrna be, és ezt nem szeretnénk
        Optional<Person> optionalPerson = personRepository.findById(id);           // movieRepository-val megpróbálom megkerestetni az id-t

        if (optionalPerson.isEmpty()){
            //throw new RuntimeException();                                       // ezt az Exceptiont nem kötelező elkapnunk, ezért jó  ->>így ezen a ponton megszakad a metódus futása... ez elkezd felfelé gyűrűzni, és valahol a Spring csinál belőle egy általános hibaüzenetet
            throw new PersonNotFoundException("Person not found with id="+id);
        }

        Person personToUpdate = modelMapper.map(personDTO, Person.class);           // MovieDTO -> Movie
        Person savePerson = personRepository.save(personToUpdate);                  // elmentem a Respository segítségével
        return modelMapper.map(savePerson, personDTO.getClass());                 // visszaadjuk MovieDTO-ként
	}

	@Override
	public void delete(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);           // előbb megkeresem, hogy van-e ilyen film

        if (optionalPerson.isPresent()){                                         // ha ez létezik ilyen movie
        	Person personToDelete = optionalPerson.get();                          // optionalMovie.get(); :: kicsomagolom a get()-el
        	personRepository.delete(personToDelete);                              // Entity-t átadva törli
        } else {
            //throw new RuntimeException();                                     // ezen általános Except. helyett felveszek egy sajátot, az exception csomagba
            throw new PersonNotFoundException("Persob not found with id="+id);    // de itt így még csak a terminálban írja ki ezt a hibát, így csinálunk egy ControllerAdvice-t, ami elkapja a Controllerből kirepülő Exceptiont
        }
	}

	// tehát mégegyszer:
    // a Service lehív az adatbázishoz
    // a movieRepository által megkaptuk az összes filmet, ami benne van
    // utána a Steam-el a listát átalakítom movieDTO típusúvá, és ezt fogom visszaadni
    // így megszületett a findAll() metódus implementációja
	
}
