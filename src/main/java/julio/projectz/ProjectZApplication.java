package julio.projectz;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import julio.projectz.model.Survivor;
import julio.projectz.repository.SurvivorRepository;

@SpringBootApplication
public class ProjectZApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectZApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(SurvivorRepository survivorRepository) {
		return args -> {
			Survivor survivor = new Survivor(null, "Julio", "Silva", "julio@gmail.com", 22, "Oi eu gosto de coca-cola", 0);
			survivor = survivorRepository.save(survivor);
			
			survivor.setAge(24);
			
			Survivor survivor2 = new Survivor(null, "Maria", "Silva", "maria@gmail.com", 32, "Oi eu gosto de coca-cola", 0);
			survivorRepository.save(survivor2);
			
			List<Survivor> survivors = survivorRepository.findAll();
			
			for (Survivor p: survivors) {
				System.out.println(p);
			}
			
		};
	}

}
