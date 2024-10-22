package com.jhonarias91;

import com.jhonarias91.model.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiUtil {

    private static final String BASE_RUL = "https://demoqa.com/";
    public static Response createUser(final String userName, final String password) {
        return given()
                .contentType(ContentType.JSON)
                .body(new User(userName, password))
                .when()
                .post(BASE_RUL+"Account/v1/User");
    }

}
