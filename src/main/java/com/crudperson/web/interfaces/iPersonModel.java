package com.crudperson.web.interfaces;

import java.util.List;

import com.crudperson.web.entities.personEntity;

public interface iPersonModel {
	public List<personEntity> listAllPerson();
	public personEntity getPerson(Long Id);
	public personEntity savePerson(personEntity person);
	public personEntity updatePerson(personEntity person);
	public void deletePerson(Long Id);
}
