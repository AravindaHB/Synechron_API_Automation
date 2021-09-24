package com.synechron.apiautomation.apitraining.specifications;

import static io.restassured.RestAssured.given;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;



public class FiltersReqAndResSpec {
	
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;

	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;

	
	public static StringWriter errWriter;
	public static PrintStream errCapture;
	
	/*
	 * 	System.out.println("Test started");
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
	
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200);
		
		System.out.println(" Test Ended ");
		
	 */
	
	@BeforeMethod
	public void beforeTest()
	{
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
		
		errWriter = new StringWriter();
		errCapture = new PrintStream(new WriterOutputStream(errWriter),true);
	}

	@Test
	public void requestWithFilter()
	{
		RestAssured.baseURI = "https://api.trello.com";
		
		given()
			.param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			filter(new RequestLoggingFilter(requestCapture)).
			filter(new ResponseLoggingFilter(responseCapture)).
		when()
			.get("/1/boards/Z7sWsmPO").
		then().
			assertThat().statusCode(200);
		
		System.err.println(requestWriter.toString());
		System.err.println(responseWriter.toString());
	
	}
}
