package julio.projectz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import julio.projectz.model.Base;
import julio.projectz.model.Survivor;
import julio.projectz.service.BaseService;
import julio.projectz.service.SurvivorService;

@SpringBootApplication
public class ProjectZApplication {

	@Autowired
	private SurvivorService survivorService;

	@Autowired
	private BaseService baseService;
	public static void main(String[] args) {
		SpringApplication.run(ProjectZApplication.class, args);
	}
	
	

}
