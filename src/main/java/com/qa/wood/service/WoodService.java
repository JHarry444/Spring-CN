package com.qa.wood.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

	public void createWood(Wood wood) {
		this.repo.save(wood);
	}

	public List<Wood> getWood() {
		return this.repo.findAll();
	}

	public void updateWood(Wood wood, Long id) {
		Wood oldWood = this.repo.findById(id).get();

		oldWood.setAge(wood.getAge());
		oldWood.setArtificial(wood.isArtificial());
		oldWood.setColour(wood.getColour());
		oldWood.setConiferous(wood.isConiferous());
		oldWood.setName(wood.getName());
		oldWood.setSoft(wood.isSoft());
		oldWood.setWeight(wood.getWeight());

		this.repo.save(oldWood);
	}

	public void deleteWood(Long id) {
		this.repo.deleteById(id);
	}

	public List<Wood> getWoodByColour(String colour) {
		return this.repo.findByColour(colour);

	}
}
