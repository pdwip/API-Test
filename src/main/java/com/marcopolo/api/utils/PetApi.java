package com.marcopolo.api.utils;

import com.marcopolo.api.dto.Pet;

public class PetApi extends RestClient {

    private static final String add_new_pet_path = "/pet";


    private String baseUrl;

    public PetApi(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Pet add_a_new_pet(Pet newPet){
       return doPost(buildBaseUrl(add_new_pet_path), newPet).extract().as(Pet.class);
    }

    public Pet get_pet(String petId){
        return doGet(buildBaseUrl(add_new_pet_path+"/"+petId)).extract().as(Pet.class);
    }

    public Pet update_pet(Pet update){
        return doPut(buildBaseUrl(add_new_pet_path), update).extract().as(Pet.class);
    }

    public void delete_pet(String petId){
        doDelete(buildBaseUrl(add_new_pet_path)+"/"+petId);
    }

    private String buildBaseUrl(String apiUrl) {
        return baseUrl + apiUrl;
    }
}
