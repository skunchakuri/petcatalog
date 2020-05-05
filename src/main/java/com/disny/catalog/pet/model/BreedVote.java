/**
 * 
 */
package com.disny.catalog.pet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author shiva
 *
 */

@Entity
@Table(name = "BREED_VOTE")
public class BreedVote {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	@Column(name = "URL")
	private String URL;
	@Column(name = "NAME")
	private String name;
	@Column(name = "VOTEUP")
	private int voteUp;
	@Column(name = "VOTEDOWN")
	private int voteDown;
	
	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		Id = id;
	}
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @param uRL the uRL to set
	 */
	public void setURL(String uRL) {
		URL = uRL;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the voteUp
	 */
	public int getVoteUp() {
		return voteUp;
	}
	/**
	 * @param voteUp the voteUp to set
	 */
	public void setVoteUp(int voteUp) {
		this.voteUp = voteUp;
	}
	/**
	 * @return the voteDown
	 */
	public int getVoteDown() {
		return voteDown;
	}
	/**
	 * @param voteDown the voteDown to set
	 */
	public void setVoteDown(int voteDown) {
		this.voteDown = voteDown;
	}
	
	

}
