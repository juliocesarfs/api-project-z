package julio.projectz.application.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import julio.projectz.application.model.District;
import julio.projectz.application.service.DistrictService;

@RestController
@RequestMapping( path = "api/v1/district" )
public class ControllerDistrict {

  @Autowired
  private DistrictService districtService;

  @GetMapping()
  public List<District> listAll() {
    return districtService.list();
  }

  @GetMapping( path = "{idDistrict}")
	public District getDistrict(@PathVariable("idDistrict") Long idDistrict) {
		return districtService.getDistrict(idDistrict);
	}

  @PostMapping
  public District include(@RequestBody @Valid District district) {
    return districtService.include(district);
  }
  
  @DeleteMapping( path = "{idDistrict}" )
	public District delete(@PathVariable("idDistrict") Long idDistrict) {
		return districtService.delete(idDistrict);
	}

  @PatchMapping( path = "{idDistrict}" )
	public District update(@RequestBody @Valid District district, @PathVariable("idDistrict") long idDistrict) {
		return districtService.update(district, idDistrict);
	}
}
