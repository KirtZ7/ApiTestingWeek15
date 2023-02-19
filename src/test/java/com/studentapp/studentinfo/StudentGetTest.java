package com.studentapp.studentinfo;

import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;


public class StudentGetTest extends TestBase {

    @Test
    public void getAllStudentsInfo() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();

    }

    @Test
    public void getSingleStudentInfo() {
        Response response = given()
                .pathParams("id","3")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void getSingleStudentInfo104() {
        Response response = given()
                .pathParams("id","104")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }


    @Test
    public void searchStudentWithParameter() {
        HashMap<String, Object> qParam = new HashMap<>();
        qParam.put("programme", "Computer Science");
        qParam.put("limit",5);

        Response response = given()
                .log().all()
                .queryParams(qParam)
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();


    }

}
