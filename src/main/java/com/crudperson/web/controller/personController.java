package com.crudperson.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.crudperson.web.entities.personEntity;
import com.crudperson.web.interfaces.iPersonModel;

@Controller
public class personController {
	@Autowired
	private iPersonModel model;
	
	@GetMapping("/")
	public String viewListPersons(Model modelo) {
		modelo.addAttribute("persons", model.listAllPerson());
		return "listPersonsViews";
	}
	
	@GetMapping("/new")
	public String newPersonForm(Model modelo) {
		personEntity person = new personEntity();
		modelo.addAttribute("person", person);
		return "formNewPersonViews";
	}
	
	@PostMapping("/newPerson")
	public String savePerson(@ModelAttribute("person") personEntity person) {
		model.savePerson(person);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editPersonForm(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("person", model.getPerson(id));
		return "formEditPersonViews";
	}
	
	@PostMapping("/updatePerson/{id}")
	public String updatePerson(@PathVariable Long id, @ModelAttribute("person") personEntity person,
			Model modelo) {
		personEntity getPerson = model.getPerson(id);
		getPerson.setId(id);
		getPerson.setNombre(person.getNombre());
		getPerson.setDescripcion(person.getDescripcion());

		model.updatePerson(getPerson);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePerson(@PathVariable Long id) {
		model.deletePerson(id);
		return "redirect:/";
	}
}
