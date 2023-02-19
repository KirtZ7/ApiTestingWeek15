package com.studentapp.studentinfo;


import com.studentapp.model.StudentPojo;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StudentPutTest {

    @Test
    public void putTest(){

        List<String> courses = new ArrayList<>();
        courses.add("Pro tester");
        courses.add("front end tester");
        courses.add("backend api testing");

        StudentPojo pojo = new StudentPojo();
        pojo.setFirstName("Kirtan");
        pojo.setLastName("Testing2");
        pojo.setEmail("testing1@gmail.com");
        pojo.setProgramme("Computer Science");
        pojo.setCourses(courses);

        Response response = given()
                .header("Content-Type", "application/json")
                .pathParams("id","104")
                .body(pojo)
                .put("/{id}");
        response.then().log().all().statusCode(200);
        response.prettyPrint();

    }

}
