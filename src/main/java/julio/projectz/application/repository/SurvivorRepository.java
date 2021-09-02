package julio.projectz.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import julio.projectz.application.model.Survivor;

@Repository
public interface SurvivorRepository extends JpaRepository<Survivor, Long>{
	
	List<Survivor> findAllByFirstName(String firstName);
	List<Survivor> findByCPF(String CPF);
	
	@Query("" +
			"SELECT CASE WHEN COUNT(p) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM Survivor p " +
			"WHERE p.CPF = ?1"
	)
	Boolean existCPF(String CPF);	
	
	
	/*
	@Query( "" +
			"SELECT firstName, lastName, email, age, description, likes " +
			"FROM Survivor p " +
			"WHERE p.firstName like ?1"
	)
	List<Survivor> findByName(String name);
	*/
}
