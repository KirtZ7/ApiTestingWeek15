package com.studentapp.studentinfo;


import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StudentDeleteTest {

    @Test
    public void delete(){
        Response response = given()
                .pathParams("id","101")
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();
    }

}
