package julio.projectz.controller;

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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import julio.projectz.model.Base;
import julio.projectz.service.BaseService;

@RestController
@RequestMapping( path = "api/v1/base" )
public class ControllerBase {

  @Autowired
  private BaseService baseService;

  @GetMapping()
  public List<Base> listAll() {
    return baseService.list();
  }

  @GetMapping( path = "{idBase}")
	public Base getBase(@PathVariable("idBase") Long idBase) {
		return baseService.getBase(idBase);
	}

  @PostMapping
  public Base include(@RequestBody @Valid Base base) {
    return baseService.include(base);
  }
  
  @DeleteMapping( path = "{idBase}" )
	public Base delete(@PathVariable("idBase") Long idBase) {
		return baseService.delete(idBase);
	}

  @PatchMapping( path = "{idBase}" )
	public Base update(@RequestBody @Valid Base base, @PathVariable("idBase") long idBase) {
		return baseService.update(base, idBase);
	}
}
