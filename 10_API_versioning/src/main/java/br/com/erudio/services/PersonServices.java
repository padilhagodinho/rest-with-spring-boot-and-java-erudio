package br.com.erudio.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v1.PersonVO;
import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.exceptions.ResourceNotFoundException;
import br.com.erudio.mapper.DozerMapper;
import br.com.erudio.mapper.custom.PersonMapper;
import br.com.erudio.model.Person;
import br.com.erudio.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PersonMapper personMapper;
	
	private Logger logger = Logger.getLogger(PersonServices.class.getName());
	
	public List<PersonVO> findAll() {
		
		logger.info("Finding all Persons!");
		
		return DozerMapper.parseListObjects(personRepository.findAll(), PersonVO.class);
	}
	
	public PersonVO findById(Long id) {
		
		logger.info("Finding one Person!");
		
		Person person = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for the ID!"));
		
		return DozerMapper.parseObject(person, PersonVO.class);
	}
	
	public PersonVO create(PersonVO personVo) {
		
		logger.info("Creating one Person!");
		
		Person person = personRepository.save(DozerMapper.parseObject(personVo, Person.class));
		
		return DozerMapper.parseObject(person, PersonVO.class);
	}
	
	public PersonVOV2 createV2(PersonVOV2 personVOV2) {
		
		logger.info("Creating one Person with v2!");
		
		Person person = personRepository.save(personMapper.convertVoV2ToEntity(personVOV2));
		
		return personMapper.convertEntityToVoV2(person);
	}
	
	public PersonVO update(PersonVO PersonVo) {
		
		logger.info("Updating one Person!");
		
		Person personUpdated = personRepository.findById(PersonVo.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for the ID!"));
		personUpdated.setFirstName(PersonVo.getFirstName());
		personUpdated.setLastName(PersonVo.getLastName());
		personUpdated.setAddress(PersonVo.getAddress());
		personUpdated.setGender(PersonVo.getGender());
		
		Person person = personRepository.save(personUpdated);
		
		return DozerMapper.parseObject(person, PersonVO.class);
	}
	
	public void delete(Long id) {
		
		logger.info("Deleting one Person!");
		
		personRepository.delete(personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for the ID!")));
	}

}
