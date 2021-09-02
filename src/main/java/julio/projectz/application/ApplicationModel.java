package julio.projectz.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@SpringBootApplication
@EntityScan(basePackageClasses = { Jsr310JpaConverters.class }, basePackages = "julio.projectz.*")
public class ApplicationModel {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationModel.class, args);
  }
  
}
