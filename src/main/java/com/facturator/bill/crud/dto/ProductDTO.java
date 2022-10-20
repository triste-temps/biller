package com.facturator.bill.crud.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

	private int pReference;
	private String pDescription;
	private Double pPrixHT;
	private Double pTauxTVA;
	private String pRemarque;
	private List <BillProductDTO> billProducts;
	
	public ProductDTO() {
		
	}

	public ProductDTO(int pReference, String pDescription, Double pPrixHT, Double pTauxTVA, String pRemarque) {
		this.pReference = pReference;
		this.pDescription = pDescription;
		this.pPrixHT = pPrixHT;
		this.pTauxTVA = pTauxTVA;
		this.pRemarque = pRemarque;
	}

	public int getpReference() {
		return pReference;
	}

	public void setpReference(int pReference) {
		this.pReference = pReference;
	}

	public String getpDescription() {
		return pDescription;
	}

	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}

	public Double getpPrixHT() {
		return pPrixHT;
	}

	public void setpPrixHT(Double pPrixHT) {
		this.pPrixHT = pPrixHT;
	}

	public Double getpTauxTVA() {
		return pTauxTVA;
	}

	public void setpTauxTVA(Double pTauxTVA) {
		this.pTauxTVA = pTauxTVA;
	}

	public String getpRemarque() {
		return pRemarque;
	}

	public void setpRemarque(String pRemarque) {
		this.pRemarque = pRemarque;
	}

	public List<BillProductDTO> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProductDTO> billProducts) {
		this.billProducts = billProducts;
	}

	
}
