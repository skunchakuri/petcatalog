/**
 * 
 */
package com.disny.catalog.pet.dao;

import static org.slf4j.LoggerFactory.getLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.disny.catalog.pet.common.PetCatalogConstants;
import com.disny.catalog.pet.common.PetLoader;
import com.disny.catalog.pet.model.BreedVote;
import com.disny.catalog.pet.model.Dog;

/**
 * @author shiva
 *
 */
@Component
public class DogRepository implements PetCatalogRepository<Dog> {

	private static final Logger LOGGER = getLogger(DogRepository.class);

	@Autowired
	PetLoader petLoader;

	@Autowired
	UserVoteRepository userVoteRepository;

	@Override
	public Map<String, List<Dog>> fetchPetList() throws Exception {
		LOGGER.info(":: Dog List ::");
		return petLoader.loadDogs();
	}

	@Override
	public List<Dog> petByType(String type) throws Exception {
		LOGGER.info(":: Dogs List by Type ::");
		return petLoader.loadDogs().get(type);

	}

	@Override
	public Dog vote(String id, Boolean type, String userName) throws Exception {
		LOGGER.info(":: Dog Vote ::");
		List<BreedVote> findAllFromDataBase = userVoteRepository.findAll();
		if (!findAllFromDataBase.isEmpty()) {
			BreedVote bv = findAllFromDataBase.stream().filter(vote -> (vote.getURL().equalsIgnoreCase(id) && vote.getName().equalsIgnoreCase(userName))).findAny().orElse(null);
			if(bv == null) {
				BreedVote dogVote = new BreedVote();
				dogVote.setURL(id);
				dogVote.setName(userName);
				if (type) {
					dogVote.setVoteUp(1);
				} else {
					dogVote.setVoteDown(1);
				}
				userVoteRepository.save(dogVote);
			}else {
				throw new Exception(userName + PetCatalogConstants.Dog.USER_ALREADY + id);
			}
		} else {
			BreedVote dogVote = new BreedVote();
			dogVote.setURL(id);
			dogVote.setName(userName);
			if (type) {
				dogVote.setVoteUp(1);
			} else {
				dogVote.setVoteDown(1);
			}
			userVoteRepository.save(dogVote);
		}
		return null;
	}

	@Override
	public Dog getPet(String id) throws Exception {
		LOGGER.info(":: Get Dog By Id ::");
		List<Dog> listOfAllDogs = new ArrayList<Dog>();
		for(Map.Entry<String, List<Dog>> entry : petLoader.loadDogs().entrySet())
			listOfAllDogs.addAll(entry.getValue());
		Dog dog = listOfAllDogs.stream().filter(d -> d.getPetImageURL().equalsIgnoreCase(id)).findAny().orElse(null);
		if(dog != null ) {
			dog.setVoteCount(userVoteRepository.findDogByUrl(dog.getPetImageURL()).stream().mapToInt( bv -> bv.getVoteDown()+bv.getVoteUp()).sum());
		}
		return dog;
	}

}
