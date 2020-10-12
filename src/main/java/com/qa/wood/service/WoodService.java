package com.qa.wood.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.wood.exceptions.WoodNotFoundException;
import com.qa.wood.persistence.domain.Wood;
import com.qa.wood.persistence.domain.WoodRepo;

//@Component
@Service
public class WoodService {

//	@Autowired
	private WoodRepo repo;

	public WoodService(WoodRepo repo) {
		super();
		this.repo = repo;
	}

	public Wood createWood(Wood wood) {
		return this.repo.save(wood);
	}

	public List<Wood> getWood() {
		return this.repo.findAll();
	}

	public Wood updateWood(Wood wood, Long id) {
		// If doesn't find a matching Wood, throw exception
		Wood oldWood = this.repo.findById(id).orElseThrow(() -> new WoodNotFoundException());

		oldWood.setAge(wood.getAge());
		oldWood.setArtificial(wood.isArtificial());
		oldWood.setColour(wood.getColour());
		oldWood.setConiferous(wood.isConiferous());
		oldWood.setName(wood.getName());
		oldWood.setSoft(wood.isSoft());
		oldWood.setWeight(wood.getWeight());

		return this.repo.save(oldWood);
	}

	public boolean deleteWood(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
