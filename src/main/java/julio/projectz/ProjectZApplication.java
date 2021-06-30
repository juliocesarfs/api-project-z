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
			Survivor survivor = new Survivor(null, "Leigh", "Windrow", "44167442000", 22, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Gabrielle", "Schmidt", "75857759030", 31, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Alf", "Curtis", "25081466093", 25, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Sadie", "Robbins", "73197000005", 56, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Humbert", "Row", "97719755014", 40, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Christian", "Valdez", "24032852006", 28, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Jasper", "Robinett", "54099048004", 18, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Audrey", "Day", "46903099069", 36, "", 0, false);
			survivor = survivorRepository.save(survivor);

			survivor = new Survivor(null, "Ken", "Ramos", "11364678071", 42, "", 0, false);
			survivor = survivorRepository.save(survivor);
			
			List<Survivor> survivors = survivorRepository.findAll();
			
			for (Survivor p: survivors) {
				System.out.println(p);
			}
			
		};
	}

}
