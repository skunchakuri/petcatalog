/**
 * 
 */
package com.disny.catalog.pet.model;

/**
 * @author shiva
 *
 */
public class PetCatalog<T> {
	
	
	
	/**
	 * @param petImageURL
	 * @param voteCount
	 */
	public PetCatalog(String petImageURL, int voteCount) {
		super();
		this.petImageURL = petImageURL;
		this.voteCount = voteCount;
	}

	private String petImageURL;
	
	private int voteCount;

	/**
	 * @return the petImageURL
	 */
	public String getPetImageURL() {
		return petImageURL;
	}

	/**
	 * @param petImageURL the petImageURL to set
	 */
	public void setPetImageURL(String petImageURL) {
		this.petImageURL = petImageURL;
	}

	/**
	 * @return the voteCount
	 */
	public int getVoteCount() {
		return voteCount;
	}

	/**
	 * @param voteCount the voteCount to set
	 */
	public void setVoteCount(int voteCount) {
		this.voteCount = voteCount;
	}
	
	

}
