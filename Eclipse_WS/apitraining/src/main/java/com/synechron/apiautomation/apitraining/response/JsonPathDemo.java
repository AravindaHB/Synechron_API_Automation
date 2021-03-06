package com.synechron.apiautomation.apitraining.response;

import static io.restassured.RestAssured.given;

import java.util.Iterator;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class JsonPathDemo {
	
	
	public void getBoardTestWithValidation() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		Response response = given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200).log().body().extract().response();
		
		String responseStr = response.asString();
		JsonPath jp = new JsonPath(responseStr);
		
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		System.out.println("ID " + jp.get("id"));
		System.out.println("NAME " + jp.get("name"));
		
		
		
		
		System.out.println(" Test Ended ");
		
	}
	
	
	
	
	@Test
	public void jsonPathValidation() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		ValidatableResponse response = given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200).log().body();
		

		System.out.println("--------------------------------------------------");
		String id  =  response.extract().path("id");
		System.out.println("id " +  id);
		
		
		// first width of an array
		int width = response.extract().path("prefs.backgroundImageScaled[0].width");
		System.out.println("First array element " + width);
		
		
		// print all witdh of an array
		int arrayCount = response.extract().path("prefs.backgroundImageScaled.size()");
		for (int i = 0; i < arrayCount; i++) {
			String value = response.extract().path("prefs.backgroundImageScaled[" + i +"].width").toString();
			System.out.println(value);
		}
		
		System.out.println(response.extract().path("prefs.backgroundImageScaled.find{ it.width ==1920 }.url").toString());
	
		
		System.out.println(response.extract().path("prefs.backgroundImageScaled.max{ it.width }").toString());
		System.out.println(response.extract().path("prefs.backgroundImageScaled.max{ it.width }.url").toString());
			
	
		System.out.println(response.extract().path("prefs.backgroundImageScaled.min{ it.width }").toString());
		System.out.println(response.extract().path("prefs.backgroundImageScaled.min{ it.width }.url").toString());
	
		
		System.out.println("Finding all the urls *************************************");
		System.out.println(response.extract().path("prefs.backgroundImageScaled.findAll{ it.width < 2400 }.url").toString());
		
		System.out.println(" Test Ended ");
		
	}
	

}
