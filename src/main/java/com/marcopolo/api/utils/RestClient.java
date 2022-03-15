package com.marcopolo.api.utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

public class RestClient {

    private static final int HTTP_OK = 200;


    protected ValidatableResponse doPost(String url, Object body) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON).setAccept(ContentType.JSON);

        ValidatableResponse response = RestAssured
                .given()
                .spec(requestSpecBuilder.build())
                .body(body).log()
                .method().log()
                .uri().log()
                .body()
                .post(url)
                .then().statusCode(HTTP_OK);
        return response;
    }

    protected ValidatableResponse doPut(String url, Object body) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON).setAccept(ContentType.JSON);

        ValidatableResponse response = RestAssured
                .given()
                .spec(requestSpecBuilder.build())
                .body(body).log()
                .method().log()
                .uri().log()
                .body()
                .put(url)
                .then().statusCode(HTTP_OK);
        return response;
    }

    protected void doDelete(String url) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON).setAccept(ContentType.JSON);

        ValidatableResponse response = RestAssured
                .given()
                .spec(requestSpecBuilder.build())
                .when()
                .log()
                .uri()
                .delete(url)
                .then().statusCode(HTTP_OK);
    }


    protected ValidatableResponse doGet(String url) {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setContentType(ContentType.JSON).setAccept(ContentType.JSON);

        ValidatableResponse response = RestAssured
                .given()
                .spec(requestSpecBuilder.build())
                .when()
                .get(url)
                .then().statusCode(HTTP_OK);
        return response;
    }

}
