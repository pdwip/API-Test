package com.marcopolo.api.test;

import com.marcopolo.api.dto.Category;
import com.marcopolo.api.dto.Pet;
import com.marcopolo.api.dto.Status;
import com.marcopolo.api.dto.Tag;
import com.marcopolo.api.helpars.CommonHelpers;
import com.marcopolo.api.utils.PetApi;
import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

public class PetTests {

    PetApi petApi;
    String baseUrl;
    CommonHelpers commonHelpers = new CommonHelpers();

    @BeforeClass
    public void setup(){

        baseUrl = commonHelpers.readConfig();
        petApi = new PetApi(baseUrl);
   }

    //create a pet with id, category name, pet name, status, tag name, photo url

    @Test
    public void createPetTest(){
        Pet petToAdd = new Pet();

        Category category = new Category();
        category.setName("huskey");

        Tag tag = new Tag();
        tag.setName("tag1");

        String samplePhotoUrl = "https://abc.com";
        petToAdd.setCategory(category);
        petToAdd.setName("doggie");
        petToAdd.setStatus(Status.available);
        petToAdd.setTags(new Tag[]{tag});
        petToAdd.setPhotoUrls(new String[]{samplePhotoUrl});
        petToAdd.setId(9223372000666126000l);

        Pet addPet = petApi.add_a_new_pet(petToAdd);
        Pet createdPet = petApi.get_pet(String.valueOf(petToAdd.getId()));

        assertThat("Pet name not  match", addPet.getName(), is(createdPet.getName()) );
        assertThat("category name not  match", addPet.getCategory().getName(), is(createdPet.getCategory().getName()) );

   //update pet
        createdPet.setStatus(Status.unavailable);

        Pet updatePet = petApi.update_pet(createdPet);

        assertThat("pet not updated", createdPet.getStatus(), is(Status.unavailable));

        //delete pet
        petApi.delete_pet(String.valueOf(updatePet.getId()));

    }



}
