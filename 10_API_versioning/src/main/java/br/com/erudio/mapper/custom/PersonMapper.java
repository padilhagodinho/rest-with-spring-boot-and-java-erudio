package br.com.erudio.mapper.custom;

import java.util.Date;

import org.springframework.stereotype.Service;

import br.com.erudio.data.vo.v2.PersonVOV2;
import br.com.erudio.model.Person;

@Service
public class PersonMapper {

	public PersonVOV2 convertEntityToVoV2(Person person) {
		PersonVOV2 vo = new PersonVOV2();
		vo.setId(person.getId());
		vo.setFirstName(person.getFirstName());
		vo.setLastName(person.getLastName());
		vo.setAddress(person.getAddress());
		vo.setBirthDay(new Date());
		vo.setGender(person.getGender());
		return vo;
	}
	
	public Person convertVoV2ToEntity(PersonVOV2 personVoV2) {
		Person person = new Person();
		person.setId(personVoV2.getId());
		person.setFirstName(personVoV2.getFirstName());
		person.setLastName(personVoV2.getLastName());
		person.setAddress(personVoV2.getAddress());
		//person.setBirthDay(new Date());
		person.setGender(personVoV2.getGender());
		return person;
	}
}
