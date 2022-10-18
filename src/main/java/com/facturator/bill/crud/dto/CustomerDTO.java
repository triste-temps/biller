package com.facturator.bill.crud.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDTO {

	private int cNumero;
	private String cType;
	private String cNomPrenomRaisonSociale;
	private String cAdresse;
	private String cCodePostal;
	private String cVille;
	private String cTelephoneMobile;
	private String cTelephoneFixe;
	private String cSiteInternet;
	private String cEmail;
	private List <BillDTO> bills;
	
	public CustomerDTO() {
		
	}

	public CustomerDTO(int cNumero, String cType, String cNomPrenomRaisonSociale, String cAdresse, String cCodePostal,
			String cVille, String cTelephoneMobile, String cTelephoneFixe, String cSiteInternet, String cEmail) {
		this.cNumero = cNumero;
		this.cType = cType;
		this.cNomPrenomRaisonSociale = cNomPrenomRaisonSociale;
		this.cAdresse = cAdresse;
		this.cCodePostal = cCodePostal;
		this.cVille = cVille;
		this.cTelephoneMobile = cTelephoneMobile;
		this.cTelephoneFixe = cTelephoneFixe;
		this.cSiteInternet = cSiteInternet;
		this.cEmail = cEmail;
	}

	public int getcNumero() {
		return cNumero;
	}

	public void setcNumero(int cNumero) {
		this.cNumero = cNumero;
	}

	public String getcType() {
		return cType;
	}

	public void setcType(String cType) {
		this.cType = cType;
	}

	public String getcNomPrenomRaisonSociale() {
		return cNomPrenomRaisonSociale;
	}

	public void setcNomPrenomRaisonSociale(String cNomPrenomRaisonSociale) {
		this.cNomPrenomRaisonSociale = cNomPrenomRaisonSociale;
	}

	public String getcAdresse() {
		return cAdresse;
	}

	public void setcAdresse(String cAdresse) {
		this.cAdresse = cAdresse;
	}

	public String getcCodePostal() {
		return cCodePostal;
	}

	public void setcCodePostal(String cCodePostal) {
		this.cCodePostal = cCodePostal;
	}

	public String getcVille() {
		return cVille;
	}

	public void setcVille(String cVille) {
		this.cVille = cVille;
	}

	public String getcTelephoneMobile() {
		return cTelephoneMobile;
	}

	public void setcTelephoneMobile(String cTelephoneMobile) {
		this.cTelephoneMobile = cTelephoneMobile;
	}

	public String getcTelephoneFixe() {
		return cTelephoneFixe;
	}

	public void setcTelephoneFixe(String cTelephoneFixe) {
		this.cTelephoneFixe = cTelephoneFixe;
	}

	public String getcSiteInternet() {
		return cSiteInternet;
	}

	public void setcSiteInternet(String cSiteInternet) {
		this.cSiteInternet = cSiteInternet;
	}

	public String getcEmail() {
		return cEmail;
	}

	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	public List<BillDTO> getBills() {
		return bills;
	}

	public void setBills(List<BillDTO> bills) {
		this.bills = bills;
	}

	
}
