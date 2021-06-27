package julio.projectz;

import java.time.Instant;
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
			Survivor survivor = new Survivor(null, "Julio", "Silva", "06958751167", 22, "Oi eu gosto de coca-cola", 0, false);
			survivor = survivorRepository.save(survivor);
			
			List<Survivor> survivors = survivorRepository.findAll();
			
			for (Survivor p: survivors) {
				System.out.println(p);
			}
			
		};
	}

}
