package com.petclinic.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

public class ApiOwner {

    @Test
    public void addOwner(){
        RestAssured
                .given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .body("{\n" +
                            "  \"address\": \"blabla\",\n" +
                            "  \"city\": \"blabla\",\n" +
                            "  \"firstName\": \"TestUser_FirstName\",\n" +
                            "  \"id\": 0,\n" +
                            "  \"lastName\": \"TestUser_LastName\",\n" +
                            "  \"telephone\": \"123\"\n" +
                            "}")

                .when()
                    .post("http://46.101.230.213:9966/petclinic/api/owners")
                .then()
                    .statusCode(201)
                    .body("firstName", equalTo("TestUser_FirstName"))
                .log().all();
    }

}
