/**
 * 
 */
package com.disny.catalog.pet.common;

/**
 * @author shiva
 *
 */
public interface PetCatalogHandler<T> {
	
	public PetResponse<T> fetchPetList();
	
	public PetResponse<T> petByType(String bytype);
	
	public PetResponse<T> vote(String id,Boolean type,String username);
	
	public PetResponse<T> getPet(String id);

}
