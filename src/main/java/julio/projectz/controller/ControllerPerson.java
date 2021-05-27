package julio.projectz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import julio.projectz.model.Person;
import julio.projectz.service.PersonService;

@RestController
@RequestMapping( path = "api/v1/person")
public class ControllerPerson {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping() 
	public List<Person> listAll() {
		return personService.list();
	}
	
	@GetMapping( path = "{idPerson}" )
	public Person getPerson(@PathVariable("idPerson") Long idPerson) {
		return personService.getPerson(idPerson);
	}
	
	@PostMapping
	public Person include(@RequestBody Person person) {
		return personService.include(person);
	}
	
	@DeleteMapping( path = "{idPerson}" )
	public Person delete(@PathVariable("idPerson") Long idPerson) {
		return personService.delete(idPerson);
	}
	
	@PatchMapping( path = "{idPerson}" )
	public Person update(@RequestBody Person person, @PathVariable("idPerson") long idPerson) {
		return personService.update(person, idPerson);
	}
	
	@RequestMapping( params = "name", method = RequestMethod.GET )
	@ResponseBody
	public List<Person> getPersonByName(@RequestParam("name") String name) {
		return personService.getPersonsByName(name);
	}
	
	@PatchMapping( path = "{idPerson}/like")
	public Person giveALike(@PathVariable("idPerson") Long idPerson) {		
		return personService.giveALike(idPerson);
	}
}
