package com.synechron.apiautomation.apitraining.ser;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompanyDetaailsPOJO {
	
	@Test
	public void generatePOJO() throws JsonProcessingException {
		CompanyDetails cd  =  new CompanyDetails();
		
		List<String> supportedBanks = new ArrayList<String>();
		supportedBanks.add("ICICI");
		supportedBanks.add("AXIS");
		supportedBanks.add("HDFC");
		
		List<String> pincode = new ArrayList<String>();
		pincode.add("1234");
		pincode.add("2222");
		pincode.add("1233");
		pincode.add("6565");
		
		Employee e1 = new Employee();
		e1.setFirstname("Aravinda");
		e1.setLastname("HB");
		e1.setAge("39");
		e1.setEmpid("EMP_007");
		e1.setEmail("aru03.info@gmail.com");
		
		Employee e2 = new Employee();
		e2.setFirstname("Harry");
		e2.setLastname("KL");
		e2.setAge("39");
		e2.setEmpid("EMP_007");
		e2.setEmail("aru03.info@gmail.com");
		
		Employee e3 = new Employee();
		e3.setFirstname("Vikky");
		e3.setLastname("KK");
		e3.setAge("39");
		e3.setEmpid("EMP_007");
		e3.setEmail("aru03.info@gmail.com");
		
		
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(e1);
		employees.add(e2);
		employees.add(e3);
		
		Contractors ct1 = new Contractors();
		ct1.setFirstname("Giri");
		ct1.setLastname("HB");
		ct1.setAge("39");
		ct1.setEmpid("EMP_007");
		ct1.setEmail("aru03.info@gmail.com");
		
		Contractors ct2 = new Contractors();
		ct2.setFirstname("Giri");
		ct2.setLastname("HB");
		ct2.setAge("39");
		ct2.setEmpid("EMP_007");
		ct2.setEmail("aru03.info@gmail.com");
		
		
		
		List<Contractors> contractors = new ArrayList<Contractors>();
		
		contractors.add(ct1);
		contractors.add(ct2);
		
		cd.setCompanyName("Synechron");
		cd.setLocation("Bangalore");
		cd.setCeo("FH");
		cd.setSupportedBank(supportedBanks);
		cd.setPin(pincode);
		cd.setEmployee(employees);
		cd.setContractors(contractors);
		
		
		ObjectMapper om = new ObjectMapper();
		String payload = om.writerWithDefaultPrettyPrinter().writeValueAsString(cd);
		
		System.out.println(payload);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
 	}

}
