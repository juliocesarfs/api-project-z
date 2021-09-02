package julio.projectz.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import julio.projectz.application.repository.DistrictRepository;
import julio.projectz.application.model.District;

@Service
public class DistrictService {

  @Autowired
  private DistrictRepository districtRepository;

  public District include(District district) {
    
    Boolean existDistrict = districtRepository.existDistrictName(district.getDistrictName());
    if (existDistrict) {
      throw new IllegalStateException("District: "+district.getDistrictName()+" essa district já existe.");
    }

    District districtReturn = districtRepository.save(district);
    
    return districtReturn;
  }

  public List<District> list() {
    return districtRepository.findAll();
  }

  public District getDistrict(Long idDistrict) {
    Optional<District> district = this.obtainDistrictIfExist(idDistrict);
    
    return district.get();
  }

  public District getDistrictByName(String districtName) {
    District district = districtRepository.findByDistrictName(districtName);

    if (district == null) {
      throw new IllegalAccessError("Nenhuma district com o nome: "+districtName+" encontrado");
    }

    return district;
  }

  public District delete(Long idDistrict) {
		Optional<District> districtOptional = obtainDistrictIfExist(idDistrict);
		District district = districtOptional.get();
		
		districtRepository.delete(district);
		
		return district;
	}

  public District update(District district, Long idDistrict) {
    Optional<District> districtOptional = obtainDistrictIfExist(idDistrict);
    District districtDB = districtOptional.get();

    if (StringUtils.hasLength(district.getDistrictName())) {
      districtDB.setDistrictName(district.getDistrictName());
    }

    districtDB = districtRepository.save(districtDB);

    return districtDB;
  }

  private Optional<District> obtainDistrictIfExist(Long idDistrict) {
		Optional<District> district = districtRepository.findById(idDistrict);
		
		if(!district.isPresent()) {
			throw new IllegalStateException("Não existe district com o id: "+idDistrict);
		}

		return district;
	}
}
