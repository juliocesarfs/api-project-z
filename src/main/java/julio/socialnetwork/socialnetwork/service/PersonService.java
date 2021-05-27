package julio.socialnetwork.socialnetwork.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import julio.socialnetwork.socialnetwork.model.Person;
import julio.socialnetwork.socialnetwork.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	
	public Person include(Person person) {
		
		Boolean existEmail = personRepository.existEmail(person.getEmail());
		if (existEmail) {
			throw new IllegalStateException("Email: "+person.getEmail()+" já está sendo utilizado por outra conta.");
		}
		
		person.setLikes(0); // todo usuário começa com zero likes
		
		Person personReturn = personRepository.save(person);
		
		return personReturn;
	}
	
	public List<Person> list() {
		return personRepository.findAll();
	}
	
	public Person getPerson(Long idPerson) {
		Optional<Person> person = this.obtainPersonIfExist(idPerson);
		
		return person.get();
	}
	
	public List<Person> getPersonsByName(String name) {
		List<Person> persons = personRepository.findAllByFirstName(name);
		
		if (CollectionUtils.isEmpty(persons)) {
			throw new IllegalAccessError("Nenhuma pessoa com o nome: "+name+" encontrado");
		}
		
		return persons;
	}
	
	public Person delete(Long idPerson) {
		Optional<Person> personOptional = obtainPersonIfExist(idPerson);
		Person person = personOptional.get();
		
		personRepository.delete(person);
		
		return person;
	}
	
	public Person update(Person person, Long idPerson) {
		Optional<Person> personOptional = obtainPersonIfExist(idPerson);
		Person personDB = personOptional.get();
		
		if (StringUtils.hasLength(person.getFirstName())) {
			personDB.setFirstName(person.getFirstName());
		}
		
		if (StringUtils.hasLength(person.getLastName())) {
			personDB.setLastName(person.getLastName());
		}
		
		if (person.getAge() != null) {
			personDB.setAge(person.getAge());
		}
		
		personDB = personRepository.save(personDB);
		
		return personDB;
	}
	
	private Optional<Person> obtainPersonIfExist(Long idPerson) {
		Optional<Person> person = personRepository.findById(idPerson);
		
		if(!person.isPresent()) {
			throw new IllegalStateException("Não existe Aluno com o ID: "+idPerson);
		}
		return person;
	}
	
	public Person giveALike(Long idPerson) {
		Optional<Person> personOptional = obtainPersonIfExist(idPerson);
		
		Person personDB = personOptional.get();
		
		Integer likes = personDB.getLikes();
		likes += 1;
		
		personDB.setLikes(likes);
		
		personDB = personRepository.save(personDB);
		
		return personDB;
	}
}
