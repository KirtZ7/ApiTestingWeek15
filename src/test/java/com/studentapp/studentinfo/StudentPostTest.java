package com.studentapp.studentinfo;

import com.studentapp.model.StudentPojo;
import com.studentapp.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class StudentPostTest extends TestBase {

    @Test
    public void createStudent() {

        List<String> courses = new ArrayList<>();
        courses.add("Pro tester");
        courses.add("front end teaster");
        courses.add("backend api testing");

        StudentPojo pojo = new StudentPojo();
        pojo.setFirstName("Kirtan");
        pojo.setLastName("Testing");
        pojo.setEmail("testin23g1@gmail.com");
        pojo.setProgramme("Computer Science");
        pojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .body(pojo)
                .post();
        response.then().log().all().statusCode(201);
        response.prettyPrint();

    }
}
