package com.disny.catalog.pet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.disny.catalog.pet.model.BreedVote;

public interface UserVoteRepository extends JpaRepository<BreedVote, Long> {

	@Query("FROM BreedVote t where t.URL = :url") 
	List<BreedVote> findDogByUrl(@Param("url") String url);

}
