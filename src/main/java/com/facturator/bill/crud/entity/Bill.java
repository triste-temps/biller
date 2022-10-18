package com.facturator.bill.crud.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="facture")	
public class Bill {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fac_numero")
	private int fNumero;
	
	@Column(name="fac_bon_de_commande")
	private int fBonDeCommande;
	
	@Column(name="fac_date_facture")
	private Date fDateFacture;
	
	@Column(name="fac_date_echeance")
	private Date fDateEcheance;
	
	@Column(name="fac_paiement_recu")
	private Date fPaiementRecu;
	
	@Column(name="fac_quantite_produit")
	private Double fQuantiteProduit;
	
	@Column(name="fac_reglement")
	private String fReglement;
	
	@Column(name="fac_pourcentage_remise")
	private Double fPourcentageRemise;
	
	@Column(name="fac_tva")
	private Double fTVA;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cli_numero")
	private Customer fk_cNumero;
	
	@OneToMany(mappedBy = "fcNumero", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List <BillProduct> billProducts;
	
	public Bill() {
		
	}

	public Bill(int fNumero, int fBonDeCommande, Date fDateFacture, Date fDateEcheance, Date fPaiementRecu,
			Double fQuantiteProduit, String fReglement, Double fPourcentageRemise, Double fTVA, Customer fk_cNumero) {
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

	public Customer getFk_cNumero() {
		return fk_cNumero;
	}

	public void setFk_cNumero(Customer fk_cNumero) {
		this.fk_cNumero = fk_cNumero;
	}

	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	@Override
	public String toString() {
		return "Bill [fNumero=" + fNumero + ", fBonDeCommande=" + fBonDeCommande + ", fDateFacture=" + fDateFacture
				+ ", fDateEcheance=" + fDateEcheance + ", fPaiementRecu=" + fPaiementRecu + ", fQuantiteProduit="
				+ fQuantiteProduit + ", fReglement=" + fReglement + ", fPourcentageRemise=" + fPourcentageRemise
				+ ", fTVA=" + fTVA + ", fk_cNumero=" + fk_cNumero + ", billProducts=" + billProducts + "]";
	}

}