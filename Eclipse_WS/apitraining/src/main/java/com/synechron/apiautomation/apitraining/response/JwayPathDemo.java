package com.synechron.apiautomation.apitraining.response;

import static io.restassured.RestAssured.given;

import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JwayPathDemo {

	
	@Test
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
		
		Map<String, ?> rootElement = JsonPath.read(response.asString(),"$");
		
		System.out.println(rootElement.toString());
		
		List<Map<String , ?>> bgArray = JsonPath.read(response.asString(),"$.prefs.backgroundImageScaled");
		
		
		for (Map<String, ? > ele : bgArray) {
			System.out.println(ele);
		}
		
		System.out.println(" Test Ended ");
		
	}
	

}
