package com.synechron.apiautomation.apitraining.post;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateRepository {
	
	@Test
	public void createRepository() {
RestAssured.baseURI = "https://api.github.com";
		
		String body = "{\r\n"
				+ "  \"name\": \"API_CREATED_REPO\"\r\n"
				+ "}";
		
		
		given().
			headers("Authorization", "Bearer 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"). 
			headers("Content-Type","application/json").
			body(body).
		when(). 
			post("/user/repos").
		then().
			assertThat().statusCode(201);
	}

}
