/**
 * 
 */
package com.disny.catalog.pet.service;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.disny.catalog.pet.dao.DogRepository;
import com.disny.catalog.pet.dao.PetCatalogRepository;
import com.disny.catalog.pet.model.Dog;

/**
 * @author shiva
 *
 */
@Service
public class DogService implements PetCatalogService<Dog> {
	
	private static final Logger LOGGER = getLogger(DogRepository.class);
	
	@Autowired
	PetCatalogRepository<Dog> dogRepository;
	 	 
	
	@Override
	public  Map<String,List<Dog>> fetchPetList() throws Exception{
		LOGGER.info(getClass().getName()+":: Dog List ::");
		return dogRepository.fetchPetList();
	}

	@Override
	public List<Dog> petByType(String type) throws Exception{
		LOGGER.info(getClass().getName()+":: petByType ::");
		return dogRepository.petByType(type);
	}

	@Override
	public Dog vote(String id, Boolean type,String name) throws Exception{
		LOGGER.info(getClass().getName()+":: vote ::");
		return dogRepository.vote(id, type,name);
	}

	@Override
	public Dog getPet(String id) throws Exception{
		LOGGER.info(getClass().getName()+":: getPet ::");
		return dogRepository.getPet(id);
	}

}
