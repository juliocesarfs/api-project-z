package julio.projectz.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import julio.projectz.model.Survivor;
import julio.projectz.repository.SurvivorRepository;

@Service
public class SurvivorService {
	
	@Autowired
	private SurvivorRepository survivorRepository;
	
	public Survivor include(Survivor survivor) {
		
		Boolean existEmail = survivorRepository.existEmail(survivor.getEmail());
		if (existEmail) {
			throw new IllegalStateException("Email: "+survivor.getEmail()+" já está sendo utilizado por outra conta.");
		}
		
		survivor.setLikes(0); // todo usuário começa com zero likes
		
		Survivor survivorReturn = survivorRepository.save(survivor);
		
		return survivorReturn;
	}
	
	public List<Survivor> list() {
		return survivorRepository.findAll();
	}
	
	public Survivor getSurvivor(Long idSurvivor) {
		Optional<Survivor> survivor = this.obtainSurvivorIfExist(idSurvivor);
		
		return survivor.get();
	}
	
	public List<Survivor> getSurvivorsByName(String name) {
		List<Survivor> survivors = survivorRepository.findAllByFirstName(name);
		
		if (CollectionUtils.isEmpty(survivors)) {
			throw new IllegalAccessError("Nenhuma pessoa com o nome: "+name+" encontrado");
		}
		
		return survivors;
	}
	
	public Survivor delete(Long idSurvivor) {
		Optional<Survivor> survivorOptional = obtainSurvivorIfExist(idSurvivor);
		Survivor survivor = survivorOptional.get();
		
		survivorRepository.delete(survivor);
		
		return survivor;
	}
	
	public Survivor update(Survivor survivor, Long idSurvivor) {
		Optional<Survivor> survivorOptional = obtainSurvivorIfExist(idSurvivor);
		Survivor survivorDB = survivorOptional.get();
		
		if (StringUtils.hasLength(survivor.getFirstName())) {
			survivorDB.setFirstName(survivor.getFirstName());
		}
		
		if (StringUtils.hasLength(survivor.getLastName())) {
			survivorDB.setLastName(survivor.getLastName());
		}
		
		if (survivor.getAge() != null) {
			survivorDB.setAge(survivor.getAge());
		}
		
		survivorDB = survivorRepository.save(survivorDB);
		
		return survivorDB;
	}
	
	private Optional<Survivor> obtainSurvivorIfExist(Long idSurvivor) {
		Optional<Survivor> survivor = survivorRepository.findById(idSurvivor);
		
		if(!survivor.isPresent()) {
			throw new IllegalStateException("Não existe Aluno com o ID: "+idSurvivor);
		}
		return survivor;
	}
	
	public Survivor giveALike(Long idSurvivor) {
		Optional<Survivor> survivorOptional = obtainSurvivorIfExist(idSurvivor);
		
		Survivor survivorDB = survivorOptional.get();
		
		Integer likes = survivorDB.getLikes();
		likes += 1;
		
		survivorDB.setLikes(likes);
		
		survivorDB = survivorRepository.save(survivorDB);
		
		return survivorDB;
	}
}
