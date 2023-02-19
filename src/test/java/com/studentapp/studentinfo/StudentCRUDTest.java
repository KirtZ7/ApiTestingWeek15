package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentCRUDTest extends TestBase {


    @Test //get all list
    public void test001() {
        Response response = given()
                .when()
                .get("/list");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test // post new and retrieve id
    public void test002() {
        List<String> courses = new ArrayList<>();
        courses.add("Pro tester");
        courses.add("front end Testing");
        courses.add("backend api testing");

        StudentPojo pojo = new StudentPojo();
        pojo.setFirstName("Kirtan TEST DATA");
        pojo.setLastName("Testing the TEST DATA");
        pojo.setEmail("TESTTTT@gmail.com");
        pojo.setProgramme("Computer TEST Science");
        pojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(pojo)
                .post();
        response.then().log().all().statusCode(201);
        response.prettyPrint();

    }

    @Test //update id
    public void test003() {
        Response response = given()
                .pathParams("id","105")
                .when()
                .get("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test //delete ID
    public void test004() {
        Response response = given()
                .pathParams("id","105")
                .when()
                .delete("/{id}");
        response.then().statusCode(204);
        response.prettyPrint();

    }


    @Test //retrieve id and validate
    public void test005() {
        Response response = given()
                .pathParams("id","105")
                .when()
                .get("/{id}");
        response.then().statusCode(404);
        response.prettyPrint();

    }

}
