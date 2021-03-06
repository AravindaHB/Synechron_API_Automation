package com.synechron.apiautomation.apitraining.specifications;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationDemo {
	
	static private RequestSpecification reqSpec;
	static private RequestSpecBuilder builder;
	
	static private ResponseSpecification resSpec;
	static private ResponseSpecBuilder resBuilder;
	
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
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeader("Server", "GitHub.com");
		resBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		resBuilder.expectContentType(ContentType.JSON);
		resBuilder.expectStatusCode(200);
		resBuilder.expectBody("owner.login", Matchers.equalTo("AravindaHB"));
		
		resSpec = resBuilder.build();
	}
	
	@Test
	public void getRepoWithReqSpecification()
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
	@Test
	
	public void getRepoWithReqAndResSpecification()
	{
		RestAssured.
			given().
				spec(reqSpec).
			when().
				get("/repos/AravindaHB/POJO_Reopsitory").
			then().spec(resSpec); 
	}
	
	

	public void getRepoWithReqAndResSpecification1()
	{
		RestAssured.
			given().
				spec(reqSpec).
			when().
				get("/repos/AravindaHB/Synechron_API_Sep").
			then().spec(resSpec); 
	}



	public void getRepoWithReqAndResSpecification2()
	{
		RestAssured.
			given().
				spec(reqSpec).
			when().
				get("/repos/AravindaHB/My-API-Project").
			then().spec(resSpec); 
	}
	

}
