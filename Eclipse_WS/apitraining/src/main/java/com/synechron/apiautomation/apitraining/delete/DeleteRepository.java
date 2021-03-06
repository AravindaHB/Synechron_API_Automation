package com.synechron.apiautomation.apitraining.delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRepository {

	
	@Test
	public void deleteRepo() {
		
		RestAssured.baseURI = "https://api.github.com";
		RestAssured.
		given().
			headers("Authorization", "Bearer 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"). 
			headers("Content-Type","application/json").
		when().
			delete("/repos/AravindaHB/My-API-Project"). 
		then(). 
			assertThat().statusCode(204);
	}
}
