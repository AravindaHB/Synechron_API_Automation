package com.synechron.apiautomation.apitraining.rootpath;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import io.restassured.RestAssured;

public class JsonPathDemo {
	
	
	public void getBoardWithoutRootElement() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200).and().body("prefs.backgroundImageScaled.width",Matchers.hasItems(140,256,480,960,1024));
		
		System.out.println(" Test Ended ");
		
	}
	
	
	
	public void getBoardTestWithValidation() {
		System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").log().params().
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			root("prefs.backgroundImageScaled").
			assertThat().statusCode(200).and().body("width",Matchers.hasItems(140,256,480,960,1024));
		
		System.out.println(" Test Ended ");
		
	}
	
	
	

}
