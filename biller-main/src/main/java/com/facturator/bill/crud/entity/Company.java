/*package com.facturator.bill.crud.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="entreprise")		
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ent_numero_siret")
	private BigInteger eNumeroSiret;
	
	@Column(name="ent_nom")
	private String eNom;
	
	@Column(name="ent_prenom")
	private String ePrenom;
	
	@Column(name="ent_nom_entreprise")
	private String eNomEntreprise;
	
	@Column(name="ent_adresse")
	private String eAdresse;
	
	@Column(name="ent_code_postal")
	private String eCodePostal;
	
	@Column(name="ent_ville")
	private String eVille;
	
	@Column(name="ent_telephone_fixe")
	private String eTelephoneFixe;
	
	public Company() {
		
	}

	public Company(BigInteger eNumeroSiret, String eNom, String ePrenom, String eNomEntreprise, String eAdresse,
			String eCodePostal, String eVille, String eTelephoneFixe) {
		this.eNumeroSiret = eNumeroSiret;
		this.eNom = eNom;
		this.ePrenom = ePrenom;
		this.eNomEntreprise = eNomEntreprise;
		this.eAdresse = eAdresse;
		this.eCodePostal = eCodePostal;
		this.eVille = eVille;
		this.eTelephoneFixe = eTelephoneFixe;
	}

	public BigInteger geteNumeroSiret() {
		return eNumeroSiret;
	}

	public void seteNumeroSiret(BigInteger eNumeroSiret) {
		this.eNumeroSiret = eNumeroSiret;
	}

	public String geteNom() {
		return eNom;
	}

	public void seteNom(String eNom) {
		this.eNom = eNom;
	}

	public String getePrenom() {
		return ePrenom;
	}

	public void setePrenom(String ePrenom) {
		this.ePrenom = ePrenom;
	}

	public String geteNomEntreprise() {
		return eNomEntreprise;
	}

	public void seteNomEntreprise(String eNomEntreprise) {
		this.eNomEntreprise = eNomEntreprise;
	}

	public String geteAdresse() {
		return eAdresse;
	}

	public void seteAdresse(String eAdresse) {
		this.eAdresse = eAdresse;
	}

	public String geteCodePostal() {
		return eCodePostal;
	}

	public void seteCodePostal(String eCodePostal) {
		this.eCodePostal = eCodePostal;
	}

	public String geteVille() {
		return eVille;
	}

	public void seteVille(String eVille) {
		this.eVille = eVille;
	}

	public String geteTelephoneFixe() {
		return eTelephoneFixe;
	}

	public void seteTelephoneFixe(String eTelephoneFixe) {
		this.eTelephoneFixe = eTelephoneFixe;
	}

	@Override
	public String toString() {
		return "Entreprise [eNumeroSiret=" + eNumeroSiret + ", eNom=" + eNom + ", ePrenom=" + ePrenom
				+ ", eNomEntreprise=" + eNomEntreprise + ", eAdresse=" + eAdresse + ", eCodePostal=" + eCodePostal
				+ ", eVille=" + eVille + ", eTelephoneFixe=" + eTelephoneFixe + "]";
	}
	
}*/