package com.synechron.apiautomation.apitraining;

import static org.hamcrest.CoreMatchers.equalTo;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RestAssuredApproach {
	
	
	//@Test
	public void getBoardUsingRestAssuredApproach()
	{
		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.param("key", "c5f676759b86029624f7dcb31ccf655e");
		reqSpec.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		
		reqSpec.get("https://api.trello.com/1/boards/Z7sWsmPO").then().statusCode(200)
		.and().body("name", equalTo("API_Created_Board"));
	}
	
	@Test
	public void getAllRepositories() {
		RestAssured.baseURI = "https://api.github.com";
		
		
		given().
			headers("Authorization", "Bearer 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").
		when(). 
			get("/repos/AravindaHB/Protractor_aug08"). 
		then(). 
			assertThat().statusCode(200);
		
	}
	
	
//	@Test
	public void getAllRepositoriesUsingExpect() {
		RestAssured.baseURI = "https://api.github.com";
		
		
		given().
			headers("Authorization", "Bearer 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"). 
		expect().statusCode(200).
		when(). 
			get("/repos/AravindaHB/Protractor_aug08"); 
		
	}

}
