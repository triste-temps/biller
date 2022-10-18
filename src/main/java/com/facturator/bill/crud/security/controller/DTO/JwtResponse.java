package com.facturator.bill.crud.security.controller.DTO;

public class JwtResponse {

	  private String token;
	  
	  private String tokeHeader;
	  
	public JwtResponse() {
		super();
	}
	
	public JwtResponse(String token, String tokeHeader) {
		super();
		this.token = token;
		this.tokeHeader = tokeHeader;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getTokeHeader() {
		return tokeHeader;
	}
	
	public void setTokeHeader(String tokeHeader) {
		this.tokeHeader = tokeHeader;
	}
}