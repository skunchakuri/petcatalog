/**
 * 
 */
package com.disny.catalog.pet.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author shiva
 *
 */
public class Dog extends PetCatalog<Dog> implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4223538246540715391L;
	
	private String breedName;
	@JsonIgnore
	private String color;
	@JsonIgnore
	private String hight;
	@JsonIgnore
	private int age;
	
	public Dog(String petImageURL, int voteCount) {
		super(petImageURL, voteCount);
	}
	
	/**
	 * @return the breedName
	 */
	public String getBreedName() {
		return breedName;
	}
	/**
	 * @param breedName the breedName to set
	 */
	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the hight
	 */
	public String getHight() {
		return hight;
	}
	/**
	 * @param hight the hight to set
	 */
	public void setHight(String hight) {
		this.hight = hight;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
