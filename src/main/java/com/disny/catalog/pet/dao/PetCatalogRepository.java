/**
 * 
 */
package com.disny.catalog.pet.dao;

import java.util.List;
import java.util.Map;

/**
 * @author shiva
 *
 */
public interface PetCatalogRepository<T> {
	
	public Map<String,List<T>> fetchPetList() throws Exception;
	
	public List<T> petByType(String type) throws Exception;
	
	public T vote(String id,Boolean type, String userName) throws Exception;
	
	public T getPet(String id)throws Exception;

}
