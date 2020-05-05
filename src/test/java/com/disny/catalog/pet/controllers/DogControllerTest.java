package com.disny.catalog.pet.controllers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.disny.catalog.pet.PetCatalogApplication;
import com.disny.catalog.pet.model.Dog;

@SpringBootTest(classes = PetCatalogApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class DogControllerTest {

	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
 
    @Test
    public void loadAllDogsGroupByBreed() 
    {
        assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/v1/dogs/", Dog.class) != null);
    }
    
    @Test
    public void dogListByBreed() 
    {
        assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/v1/dogs/Labrador/all", Dog.class) != null);
    }
    
    @Test
    public void dogDetailsById() 
    {
        assertTrue(
                this.restTemplate
                    .getForObject("http://localhost:" + port + "/v1/dogs/?id=http://i.imgur.com/eE29vX4.png", Dog.class) != null);
    }
    
    @Test
    public void vote() 
    {
    		this.restTemplate
                    .put("http://localhost:" + port + "/v1/dogs/?vote?id=http://i.imgur.com/eE29vX4.png&type=false", Dog.class);
    		assertTrue(true);
    }
 

}
