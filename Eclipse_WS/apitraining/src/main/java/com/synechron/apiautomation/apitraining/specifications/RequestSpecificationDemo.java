package com.synechron.apiautomation.apitraining.specifications;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationDemo {
	
	static private RequestSpecification reqSpec;
	static private RequestSpecBuilder builder;
	
	String baseUri = "https://api.github.com";
	String projectName = "API_PROJECT_USING_REQ_SPE";
	String barrierToken = "Bearer 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";
	
	
	@BeforeClass
	public void getSpecObj() {
		RestAssured.baseURI = baseUri;
		builder = new RequestSpecBuilder();
		builder.addHeader("Authorization", barrierToken);
		builder.addHeader("Content-Type","application/json");
		
		reqSpec = builder.build();
	}
	
	@Test
	public void createRepoWithSpecification()
	{
		RestAssured.
			given().
				spec(reqSpec).
			when().
				get("/repos/AravindaHB/POJO_Reopsitory").
			then(). 
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().log().all().and().
			body("name", CoreMatchers.equalTo("POJO_Reopsitory"));
	}
	

}
