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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import julio.projectz.application.model.Survivor;
import julio.projectz.application.service.SurvivorService;

@RestController
@RequestMapping( path = "api/v1/survivor")
public class ControllerSurvivor {
	
	@Autowired
	private SurvivorService survivorService;
	
	@GetMapping() 
	public List<Survivor> listAll() {
		return survivorService.list();
	}
	
	@GetMapping( path = "{idSurvivor}" )
	public Survivor getSurvivor(@PathVariable("idSurvivor") Long idSurvivor) {
		return survivorService.getSurvivor(idSurvivor);
	}
	
	@PostMapping
	public Survivor include(@RequestBody @Valid Survivor survivor) {
		return survivorService.include(survivor);
	}
	
	@DeleteMapping( path = "{idSurvivor}" )
	public Survivor delete(@PathVariable("idSurvivor") Long idSurvivor) {
		return survivorService.delete(idSurvivor);
	}
	
	@PatchMapping( path = "{idSurvivor}" )
	public Survivor update(@RequestBody @Valid Survivor survivor, @PathVariable("idSurvivor") long idSurvivor) {
		return survivorService.update(survivor, idSurvivor);
	}
	
	@RequestMapping( params = "name", method = RequestMethod.GET )
	@ResponseBody
	public List<Survivor> getSurvivorByName(@RequestParam("name") String name) {
		return survivorService.getSurvivorsByName(name);
	}
	
	@PatchMapping( path = "{idSurvivor}/flag")
	public Survivor reportSurvivor(@PathVariable("idSurvivor") Long idSurvivor) {		
		return survivorService.giveAFlag(idSurvivor);
	}
}
