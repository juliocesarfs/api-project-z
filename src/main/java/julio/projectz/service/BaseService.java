package julio.projectz.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import julio.projectz.model.Base;
import julio.projectz.repository.BaseRepository;

@Service
public class BaseService {

  @Autowired
  private BaseRepository baseRepository;

  public Base include(Base base) {
    
    Boolean existBase = baseRepository.existBaseName(base.getBaseName());
    if (existBase) {
      throw new IllegalStateException("Base: "+base.getBaseName()+" essa base já existe.");
    }

    Base baseReturn = baseRepository.save(base);
    
    return baseReturn;
  }

  public List<Base> list() {
    return baseRepository.findAll();
  }

  public Base getBase(Long idBase) {
    Optional<Base> base = this.obtainBaseIfExist(idBase);
    
    return base.get();
  }

  public Base getBaseByName(String baseName) {
    Base base = baseRepository.findByBaseName(baseName);

    if (base == null) {
      throw new IllegalAccessError("Nenhuma base com o nome: "+baseName+" encontrado");
    }

    return base;
  }

  public Base delete(Long idBase) {
		Optional<Base> baseOptional = obtainBaseIfExist(idBase);
		Base base = baseOptional.get();
		
		baseRepository.delete(base);
		
		return base;
	}

  public Base update(Base base, Long idBase) {
    Optional<Base> baseOptional = obtainBaseIfExist(idBase);
    Base baseDB = baseOptional.get();

    if (StringUtils.hasLength(base.getBaseName())) {
      baseDB.setBaseName(base.getBaseName());
    }

    baseDB = baseRepository.save(baseDB);

    return baseDB;
  }

  private Optional<Base> obtainBaseIfExist(Long idBase) {
		Optional<Base> base = baseRepository.findById(idBase);
		
		if(!base.isPresent()) {
			throw new IllegalStateException("Não existe base com o id: "+idBase);
		}

		return base;
	}
}
