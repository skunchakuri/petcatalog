/**
 * 
 */
package com.disny.catalog.pet.controllers;

import static org.slf4j.LoggerFactory.getLogger;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.disny.catalog.pet.common.PetCatalogConstants;
import com.disny.catalog.pet.common.PetCatalogHandler;
import com.disny.catalog.pet.common.PetResponse;
import com.disny.catalog.pet.dao.DogRepository;
import com.disny.catalog.pet.model.Dog;
import com.disny.catalog.pet.service.PetCatalogService;

import io.swagger.annotations.Api;

/**
 * @author shiva
 * @param <T>
 *
 */

@RestController
@RequestMapping("/v1/dogs/")
@Api(value = "Dogs Information Based on Breeds")
public class DogController<T> implements PetCatalogHandler<Dog> {
	
	private static final Logger LOGGER = getLogger(DogRepository.class);

	@Autowired
	PetCatalogService<Dog> dogService;
	
	@Override
	@GetMapping("all")
	public PetResponse<Dog> fetchPetList() {
		PetResponse<Dog> response = new PetResponse<Dog>();
		LOGGER.info(getClass().getName()+":: fetchPetList ::");
		try {
			response.setPetsGroupBy(dogService.fetchPetList());
			response.setStatusCode(HttpStatus.OK);
			response.setStatusMessage(PetCatalogConstants.SUCCESS);
			response.setUserMessage(PetCatalogConstants.Dog.ALL);
		} catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusMessage(PetCatalogConstants.FAILURE);
			response.setUserMessage(e.getMessage());
		}
		return response;
	}

	@Override
	@GetMapping("{bytype}/all")
	public PetResponse<Dog> petByType(@PathVariable("bytype") String bytype) {
		PetResponse<Dog> response = new PetResponse<Dog>();
		LOGGER.info(getClass().getName()+":: petByType ::");
		try {
			response.setPetsList(dogService.petByType(bytype));
			response.setStatusCode(HttpStatus.OK);
			response.setStatusMessage(PetCatalogConstants.SUCCESS);
			response.setUserMessage(PetCatalogConstants.Dog.BYTYEP);
			LOGGER.info(getClass().getName()+":: Dog List ::");
		} catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusMessage(PetCatalogConstants.FAILURE);
			response.setUserMessage(e.getMessage());
		}
		return response;
	}

	@Override
	@PostMapping("vote")
	public PetResponse<Dog> vote(@RequestParam("id") String id,@RequestParam("type") Boolean type,@RequestParam("username") String username) {
		PetResponse<Dog> response = new PetResponse<Dog>();
		LOGGER.info(getClass().getName()+":: vote ::");
		try {
			response.setPet(dogService.vote(id, type,username));
			response.setStatusCode(HttpStatus.OK);
			response.setStatusMessage(PetCatalogConstants.SUCCESS);
			response.setUserMessage(PetCatalogConstants.Dog.VOTE);
		} catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusMessage(PetCatalogConstants.FAILURE);
			response.setUserMessage(e.getMessage());
		}
		return response;
	}

	@Override
	@GetMapping()
	public PetResponse<Dog> getPet(@RequestParam("id") String id) {
		PetResponse<Dog> response = new PetResponse<Dog>();
		LOGGER.info(getClass().getName()+":: getPet ::");
		try {
			Dog dog = dogService.getPet(id);
			if(dog != null ) {
				response.setPet(dog);
			}else {
				throw new Exception(PetCatalogConstants.Dog.NO_DOG);
			}
			response.setStatusCode(HttpStatus.OK);
			response.setStatusMessage(PetCatalogConstants.SUCCESS);
			response.setUserMessage(PetCatalogConstants.Dog.DETAILS);
		} catch (Exception e) {
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatusMessage(PetCatalogConstants.FAILURE);
			response.setUserMessage(e.getMessage());
		}
		return response;
	}

}
