package com.qa.wood.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qa.wood.exceptions.WoodNotFoundException;
import com.qa.wood.persistence.domain.Wood;
import com.qa.wood.persistence.repos.WoodRepo;

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
		Optional<Wood> optWood = this.repo.findById(id);
		Wood oldWood = optWood.orElseThrow(() -> new WoodNotFoundException());

		oldWood.setAge(wood.getAge());
		oldWood.setArtificial(wood.isArtificial());
		oldWood.setColour(wood.getColour());
		oldWood.setConiferous(wood.isConiferous());
		oldWood.setName(wood.getName());
		oldWood.setSoft(wood.isSoft());
		oldWood.setWeight(wood.getWeight());

		Wood saved = this.repo.save(oldWood);
		return saved;
	}

	public boolean deleteWood(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
}
