package br.com.erudio.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Person;

@Service
public class PersonServices {
	
	private static AtomicLong counter = new AtomicLong();
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public Person findById(String id) {
		
		logger.info("Finding one Person!");
		
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Leandro");
		person.setLastaName("Costa");
		person.setAddress("Berlandia - Minas - Brasel");
		person.setGender("Male");
		
		return person;
	}
	
	public List<Person> findAll() {
		
		logger.info("Finding all Persons!");
		
		List<Person> persons = new ArrayList<Person>();
		
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		
		return persons;
	}
	
	public Person create(Person person) {
		logger.info("Creating one Person!");
		return person;
	}
	
	public Person update(Person person) {
		logger.info("Updating one Person!");
		return person;
	}
	
	public void delete(String id) {
		logger.info("Deleting one Person!");
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name "+i);
		person.setLastaName("Last Name "+i);
		person.setAddress("Some address in Brasil "+i);
		person.setGender("Male");
		return person;
	}

}
