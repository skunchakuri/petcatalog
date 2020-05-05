/**
 * 
 */
package com.disny.catalog.pet.common;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

/**
 * @author shiva
 *
 */
public class PetResponse<T> {
	
	private HttpStatus statusCode;
	
	private String statusMessage;
	
	private String userMessage;
	
	private List<T> petsList;	
	
	private Map<String,List<T>> petsGroupBy;	

	private T pet;
	
	
	/**
	 * @return the petsGroupBy
	 */
	public Map<String, List<T>> getPetsGroupBy() {
		return petsGroupBy;
	}

	/**
	 * @param petsGroupBy the petsGroupBy to set
	 */
	public void setPetsGroupBy(Map<String, List<T>> petsGroupBy) {
		this.petsGroupBy = petsGroupBy;
	}

	/**
	 * @return the statusCode
	 */
	public HttpStatus getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage the statusMessage to set
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	/**
	 * @return the userMessage
	 */
	public String getUserMessage() {
		return userMessage;
	}

	/**
	 * @param userMessage the userMessage to set
	 */
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}

	/**
	 * @return the petsList
	 */
	public List<T> getPetsList() {
		return petsList;
	}

	/**
	 * @param petsList the petsList to set
	 */
	public void setPetsList(List<T> petsList) {
		this.petsList = petsList;
	}

	/**
	 * @return the pet
	 */
	public T getPet() {
		return pet;
	}

	/**
	 * @param pet the pet to set
	 */
	public void setPet(T pet) {
		this.pet = pet;
	}
	
	
}
