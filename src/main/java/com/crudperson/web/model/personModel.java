package com.crudperson.web.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudperson.web.entities.personEntity;
import com.crudperson.web.interfaces.iPersonModel;
import com.crudperson.web.interfaces.iPersonRepository;

@Service
public class personModel implements iPersonModel {
	@Autowired
	private iPersonRepository repository;

	@Override
	public List<personEntity> listAllPerson() {
		return repository.findAll();
	}
	
	@Override
	public personEntity getPerson(Long Id) {
		return repository.findById(Id).get();
	}
	
	@Override
	public personEntity savePerson(personEntity person) {
		return repository.save(person);
	}
	
	@Override
	public personEntity updatePerson(personEntity person) {
		return repository.save(person);
	}
	
	@Override
	public void deletePerson(Long Id) {
		repository.deleteById(Id);
	}
}
