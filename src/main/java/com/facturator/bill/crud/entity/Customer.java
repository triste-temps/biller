package com.facturator.bill.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")	
public class Customer {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="cli_numero")
	private int cNumero;
	
	@Column(name="cli_type")
	private String cType;
	
	@Column(name="cli_nom_prenom_raison_sociale")
	private String cNomPrenomRaisonSociale;
	
	@Column(name="cli_adresse")
	private String cAdresse;
	
	@Column(name="cli_code_postal")
	private String cCodePostal;
	
	@Column(name="cli_ville")
	private String cVille;
	
	@Column(name="cli_telephone_mobile")
	private String cTelephoneMobile;
	
	@Column(name="cli_telephone_fixe")
	private String cTelephoneFixe;
	
	@Column(name="cli_site_internet")
	private String cSiteInternet;
	
	@Column(name="cli_email")
	private String cEmail;
	
	@OneToMany(mappedBy = "fk_cNumero", cascade = CascadeType.ALL)
	private List <Bill> bills;
	
	public Customer() {
		
	}

	public Customer(int cNumero, String cType, String cNomPrenomRaisonSociale, String cAdresse, String cCodePostal,
			String cVille, String cTelephoneMobile, String cTelephoneFixe, String cSiteInternet, String cEmail,
			List<Bill> bills) {
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
		this.bills = bills;
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

	public List<Bill> getBills() {
		return bills;
	}

	public void setBills(List<Bill> bills) {
		this.bills = bills;
	}

	@Override
	public String toString() {
		return "Customer [cNumero=" + cNumero + ", cType=" + cType + ", cNomPrenomRaisonSociale="
				+ cNomPrenomRaisonSociale + ", cAdresse=" + cAdresse + ", cCodePostal=" + cCodePostal + ", cVille="
				+ cVille + ", cTelephoneMobile=" + cTelephoneMobile + ", cTelephoneFixe=" + cTelephoneFixe
				+ ", cSiteInternet=" + cSiteInternet + ", cEmail=" + cEmail + ", bills=" + bills + "]";
	}

	
}
