package com.synechron.apiautomation.apitraining.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateRepositoryUsingPOJO {
	
	@Test
	public void createRepository() {
RestAssured.baseURI = "https://api.github.com";
		
		GitRepoPOJO gp = new GitRepoPOJO();
		gp.setName("POJO_Reopsitory");
		gp.setDescription("POJO_Desc");
		
		given().
			headers("Authorization", "Bearer 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"). 
			headers("Content-Type","application/json").
			body(gp).
		when(). 
			post("/user/repos").
		then().
			assertThat().statusCode(201);
	}

}
