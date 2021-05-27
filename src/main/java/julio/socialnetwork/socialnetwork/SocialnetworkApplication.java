package julio.socialnetwork.socialnetwork;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import julio.socialnetwork.socialnetwork.model.Person;
import julio.socialnetwork.socialnetwork.repository.PersonRepository;

@SpringBootApplication
public class SocialnetworkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialnetworkApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(PersonRepository personRepository) {
		return args -> {
			Person person = new Person(null, "Julio", "Silva", "julio@gmail.com", 22, "Oi eu gosto de coca-cola", 0);
			person = personRepository.save(person);
			
			person.setAge(24);
			
			Person person2 = new Person(null, "Maria", "Silva", "maria@gmail.com", 32, "Oi eu gosto de coca-cola", 0);
			personRepository.save(person2);
			
			List<Person> persons = personRepository.findAll();
			
			for (Person p: persons) {
				System.out.println(p);
			}
			
		};
	}

}
