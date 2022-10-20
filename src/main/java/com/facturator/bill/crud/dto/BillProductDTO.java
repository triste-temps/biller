package com.facturator.bill.crud.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillProductDTO {

	private int fcId;
	private BillDTO fcNumero;
	private ProductDTO fcReference;
	
	public BillProductDTO() {
		
	}

	public BillProductDTO(int fcId, BillDTO fcNumero, ProductDTO fcReference) {
		this.fcId = fcId;
		this.fcNumero = fcNumero;
		this.fcReference = fcReference;
	}

	public int getFcId() {
		return fcId;
	}

	public void setFcId(int fcId) {
		this.fcId = fcId;
	}

	public BillDTO getFcNumero() {
		return fcNumero;
	}

	public void setFcNumero(BillDTO fcNumero) {
		this.fcNumero = fcNumero;
	}

	public ProductDTO getFcReference() {
		return fcReference;
	}

	public void setFcReference(ProductDTO fcReference) {
		this.fcReference = fcReference;
	}

}