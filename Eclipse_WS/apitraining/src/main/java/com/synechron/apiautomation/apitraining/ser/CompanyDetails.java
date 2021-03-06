package com.synechron.apiautomation.apitraining.ser;

import java.util.List;

public class CompanyDetails {
	
	//one to one mapping
	private String companyName;
	private String location;
	private String ceo;
	
	//list of elements
	private List<String> supportedBank;
	private List<String>pin;
	
	
	private List<Employee> employee;
	private List<Contractors> contractors;
	
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public List<String> getSupportedBank() {
		return supportedBank;
	}
	public void setSupportedBank(List<String> supportedBank) {
		this.supportedBank = supportedBank;
	}
	public List<String> getPin() {
		return pin;
	}
	public void setPin(List<String> pin) {
		this.pin = pin;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public List<Contractors> getContractors() {
		return contractors;
	}
	public void setContractors(List<Contractors> contractors) {
		this.contractors = contractors;
	}	
	

}
