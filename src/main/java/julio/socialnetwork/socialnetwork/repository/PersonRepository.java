package julio.socialnetwork.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import julio.socialnetwork.socialnetwork.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	List<Person> findAllByFirstName(String firstName);
	List<Person> findByEmail(String email);
	
	@Query("" +
			"SELECT CASE WHEN COUNT(p) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM Person p " +
			"WHERE p.email = ?1"
	)
	Boolean existEmail(String email);	
	
	
	/*
	@Query( "" +
			"SELECT firstName, lastName, email, age, description, likes " +
			"FROM Person p " +
			"WHERE p.firstName like ?1"
	)
	List<Person> findByName(String name);
	*/
}
