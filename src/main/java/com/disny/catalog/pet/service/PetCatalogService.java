/**
 * 
 */
package com.disny.catalog.pet.service;

import java.util.List;
import java.util.Map;

import com.disny.catalog.pet.model.Dog;

/**
 * @author shiva
 *
 */
public interface PetCatalogService<T> {
	
	public  Map<String,List<Dog>> fetchPetList() throws Exception;
	
	public List<T> petByType(String type) throws Exception;
	
	public T vote(String id,Boolean type, String userName) throws Exception;
	
	public T getPet(String id) throws Exception;

}
