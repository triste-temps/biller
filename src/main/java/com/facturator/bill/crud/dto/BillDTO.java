package com.facturator.bill.crud.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillDTO {

	private int fNumero;
	private int fBonDeCommande;
	private Date fDateFacture;
	private Date fDateEcheance;
	private Date fPaiementRecu;
	private Double fQuantiteProduit;
	private String fReglement;
	private Double fPourcentageRemise;
	private Double fTVA;
	private CustomerDTO fk_cNumero;
	private List <BillProductDTO> billProducts;
	
	BillDTO(){
		
	}

	public BillDTO(int fNumero, int fBonDeCommande, Date fDateFacture, Date fDateEcheance, Date fPaiementRecu,
			Double fQuantiteProduit, String fReglement, Double fPourcentageRemise, Double fTVA,
			CustomerDTO fk_cNumero) {
		this.fNumero = fNumero;
		this.fBonDeCommande = fBonDeCommande;
		this.fDateFacture = fDateFacture;
		this.fDateEcheance = fDateEcheance;
		this.fPaiementRecu = fPaiementRecu;
		this.fQuantiteProduit = fQuantiteProduit;
		this.fReglement = fReglement;
		this.fPourcentageRemise = fPourcentageRemise;
		this.fTVA = fTVA;
		this.fk_cNumero = fk_cNumero;
	}

	public int getfNumero() {
		return fNumero;
	}

	public void setfNumero(int fNumero) {
		this.fNumero = fNumero;
	}

	public int getfBonDeCommande() {
		return fBonDeCommande;
	}

	public void setfBonDeCommande(int fBonDeCommande) {
		this.fBonDeCommande = fBonDeCommande;
	}

	public Date getfDateFacture() {
		return fDateFacture;
	}

	public void setfDateFacture(Date fDateFacture) {
		this.fDateFacture = fDateFacture;
	}

	public Date getfDateEcheance() {
		return fDateEcheance;
	}

	public void setfDateEcheance(Date fDateEcheance) {
		this.fDateEcheance = fDateEcheance;
	}

	public Date getfPaiementRecu() {
		return fPaiementRecu;
	}

	public void setfPaiementRecu(Date fPaiementRecu) {
		this.fPaiementRecu = fPaiementRecu;
	}

	public Double getfQuantiteProduit() {
		return fQuantiteProduit;
	}

	public void setfQuantiteProduit(Double fQuantiteProduit) {
		this.fQuantiteProduit = fQuantiteProduit;
	}

	public String getfReglement() {
		return fReglement;
	}

	public void setfReglement(String fReglement) {
		this.fReglement = fReglement;
	}

	public Double getfPourcentageRemise() {
		return fPourcentageRemise;
	}

	public void setfPourcentageRemise(Double fPourcentageRemise) {
		this.fPourcentageRemise = fPourcentageRemise;
	}

	public Double getfTVA() {
		return fTVA;
	}

	public void setfTVA(Double fTVA) {
		this.fTVA = fTVA;
	}

	public CustomerDTO getFk_cNumero() {
		return fk_cNumero;
	}

	public void setFk_cNumero(CustomerDTO fk_cNumero) {
		this.fk_cNumero = fk_cNumero;
	}

	public List<BillProductDTO> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProductDTO> billProducts) {
		this.billProducts = billProducts;
	}

}