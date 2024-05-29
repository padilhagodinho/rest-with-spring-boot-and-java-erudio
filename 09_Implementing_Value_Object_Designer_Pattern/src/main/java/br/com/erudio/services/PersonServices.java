package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<Person> findAll() {
		
		logger.info("Finding all Persons!");
		
		return personRepository.findAll();
	}
	
	public Person findById(Long id) {
		
		logger.info("Finding one Person!");
		
		return personRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for the ID!"));
	}
	
	public Person create(Person person) {
		
		logger.info("Creating one Person!");
		
		return personRepository.save(person);
	}
	
	public Person update(Person person) {
		
		logger.info("Updating one Person!");
		
		Person personUpdated = findById(person.getId());
		personUpdated.setFirstName(person.getFirstName());
		personUpdated.setLastName(person.getLastName());
		personUpdated.setAddress(person.getAddress());
		personUpdated.setGender(person.getGender());
		
		return personRepository.save(personUpdated);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one Person!");
		
		personRepository.delete(findById(id));
	}

}
