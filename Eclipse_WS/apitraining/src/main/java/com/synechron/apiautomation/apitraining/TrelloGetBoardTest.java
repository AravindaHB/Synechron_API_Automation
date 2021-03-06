package com.synechron.apiautomation.apitraining;


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
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200);
		
		System.out.println(" Test Ended ");
		
	}
	
	
	
	
	@Test
	public void getBoardAndReadBodyTest() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name", equalTo("API_Created_Board"));
			
		
		System.out.println(" Test Ended ");
		
	}
	


	@Test
	public void getBoardUsingQueryParameter() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		RestAssured.
		given()
			.queryParam("key", "c5f676759b86029624f7dcb31ccf655e")
			.queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name", equalTo("API_Created_Board"));
			
		
		System.out.println(" Test Ended ");
		
	}

	@Test
	public void getBoardUsingQueryParameters() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		RestAssured.
		given()
			.queryParams("key", "c5f676759b86029624f7dcb31ccf655e","token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name", equalTo("API_Created_Board"));
			
		
		System.out.println(" Test Ended ");
		
	}
	

	@Test
	public void getBoardUsingMapQueryParameters() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		HashMap<String, String> mp = new HashMap<String,String>();
		
		mp.put("key", "c5f676759b86029624f7dcb31ccf655e");
		mp.put("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		
		RestAssured.
		given().
			params(mp).
		when().
			get("/1/boards/Z7sWsmPO").
		then().
			assertThat().
				statusCode(200).and().
				contentType(ContentType.JSON).and().
				body("name", equalTo("API_Created_Board"));
			
		
		System.out.println(" Test Ended ");
		
	}
	
	
	
}
