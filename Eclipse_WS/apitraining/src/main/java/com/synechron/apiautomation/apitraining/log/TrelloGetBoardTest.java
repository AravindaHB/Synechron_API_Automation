package com.synechron.apiautomation.apitraining.log;


import java.util.HashMap;

import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TrelloGetBoardTest
{
	
	
	@Test
	public void getBoardTest() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200).log().body();
		
		System.out.println(" Test Ended ");
		
	}
	
	
	
	
}
