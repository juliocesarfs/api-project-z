package julio.projectz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import julio.projectz.model.Base;

@Repository
public interface BaseRepository extends JpaRepository<Base, Long>{

  Base findByBaseName(String baseName);

  @Query("" +
			"SELECT CASE WHEN COUNT(b) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM Base b " +
			"WHERE b.baseName = ?1"
	)
	Boolean existBaseName(String CPF);	
}
