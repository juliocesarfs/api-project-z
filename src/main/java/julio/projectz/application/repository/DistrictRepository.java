package julio.projectz.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import julio.projectz.application.model.District;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>{


	@Query("" +
			"FROM District b " +
			"WHERE b.districtName = ?1"
	)
  District findByDistrictName(String districtName);

  @Query("" +
			"SELECT CASE WHEN COUNT(b) > 0 THEN " +
			"TRUE ELSE FALSE END " +
			"FROM District b " +
			"WHERE b.districtName = ?1"
	)
	Boolean existDistrictName(String districtName);	
}
