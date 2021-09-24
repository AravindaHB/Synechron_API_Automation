package com.synechron.apiautomation.apitraining.post;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DeserializePOJO {
	
	
	@Test
	public void deserializeTest() throws JsonProcessingException
	{
		
		//Serialization
		GitRepoPOJO gp = new GitRepoPOJO();
		gp.setName("POJO_Reopsitory");
		gp.setDescription("POJO_Desc");
		
		//Deserialization
		ObjectMapper ob = new ObjectMapper();
		String jsonObjString = ob.writerWithDefaultPrettyPrinter().writeValueAsString(gp);
		
		System.out.println(jsonObjString);
		
		
	}

}
