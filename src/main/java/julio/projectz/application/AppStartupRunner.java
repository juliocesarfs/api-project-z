package julio.projectz.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import julio.projectz.application.model.District;
import julio.projectz.application.model.Survivor;
import julio.projectz.application.repository.DistrictRepository;
import julio.projectz.application.repository.SurvivorRepository;

@Component
public class AppStartupRunner implements ApplicationRunner {
  public static final String NONE="none";
  public static final String CREATE_DROP="create-drop";
  public static final String CREATE = "create";
  public static final String UPDATE = "update";

  private static final Logger LOG =
          LoggerFactory.getLogger(AppStartupRunner.class);
  
  @Value("${spring.jpa.hibernate.ddl-auto}")
  private String ddlAuto;

  @Autowired
  SurvivorRepository survivorRepository;

  @Autowired
  DistrictRepository districtRepository;


  @Override
  public void run(ApplicationArguments args) throws Exception {
    LOG.info("Application started with option names : {}",
              args.getOptionNames());
    LOG.info("spring.jpa.hibernate.ddl-auto={}", ddlAuto);

    if (this.ddlAuto.trim().equals(CREATE_DROP) ||
             this.ddlAuto.trim().equals(CREATE) ||
             this.ddlAuto.trim().equals(UPDATE)
    ) {
      this.initiateDemoInstance();
    }
    
  }

  private void initiateDemoInstance() {
    LOG.info("initiateDemoInstance");
    createDistricts();
    createSurvivors();
  }

  private void createSurvivors() {
    Survivor survivor = new Survivor(null, "Leigh", "Windrow", "44167442000", 22, "", 0, false);
		survivor = survivorRepository.save(survivor);

		survivor = new Survivor(null, "Gabrielle", "Schmidt", "75857759030", 31, "", 0, false);			survivor = survivorRepository.save(survivor);

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
  }

  private void createDistricts() {
    District district = new District("Andromeda");
    district = districtRepository.save(district);

    district = new District("Alaska");
    district = districtRepository.save(district);

    district = new District("Charlie");
    district = districtRepository.save(district);

    district = new District("Oscar");
    district = districtRepository.save(district);

  }

}
