package com.disny.catalog.pet.common;

import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.disny.catalog.pet.model.Dog;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@Component
public class PetLoader implements InitializingBean {

    private static final Logger LOGGER = getLogger(PetLoader.class);

    // Resources to the different files we need to load.
    @Value("classpath:data/labrador.txt")
    private Resource labradors;

    @Value("classpath:data/pug.txt")
    private Resource pugs;

    @Value("classpath:data/retriever.txt")
    private Resource retrievers;

    @Value("classpath:data/yorkie.txt")
    private Resource yorkies;

    @Autowired
    DataSource dataSource;
    
    Map<String,List<Dog>> dogsMap = new HashMap<>();

    /**
     * Load the different breeds into the data source after
     * the application is ready.
     * @return 
     *
     * @throws Exception In case something goes wrong while we load the breeds.
     */
    @Override
    public void afterPropertiesSet() throws Exception {
    	dogsMap.put("Labrador", loadBreed("Labrador", labradors));
    	dogsMap.put("Pug", loadBreed("Pug", pugs));
    	dogsMap.put("Retriever", loadBreed("Retriever", retrievers));
    	dogsMap.put("Yorkie", loadBreed("Yorkie", yorkies));
    }
    
    public Map<String,List<Dog>> loadDogs() throws Exception {
    	return dogsMap;
    }

    /**
     * Reads the list of dogs in a category and (eventually) add
     * them to the data source.
     * @param breed The breed that we are loading.
     * @param source The file holding the breeds.
     * @throws IOException In case things go horribly, horribly wrong.
     */
    private List<Dog> loadBreed(String breed, Resource source) throws IOException {
        LOGGER.info("Loading breed {}", breed);
        List<Dog> dogsList = new ArrayList<Dog>();
        try ( BufferedReader br = new BufferedReader(new InputStreamReader(source.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                LOGGER.debug(line);
                // TODO: Create appropriate objects and save them to the datasource.
                Dog dog = new Dog(line,0);
                if("Labrador".equalsIgnoreCase(breed)) {
                	dog.setBreedName(breed);
                }else if("Pug".equalsIgnoreCase(breed)) {
                	 dog.setBreedName(breed);
                }else if("Retriever".equalsIgnoreCase(breed)) {
                	 dog.setBreedName(breed);
                }else if("Yorkie".equalsIgnoreCase(breed)) {
                	 dog.setBreedName(breed);
                }
                dogsList.add(dog);
            }
        }
        return dogsList;
    }
}
