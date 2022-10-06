package com.facturator.bill.crud.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facture_produit")	
public class BillProduct {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id	
	@JoinColumn(name="fc_id")
	private int fcId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="fac_numero")
	private Bill fcNumero;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="pro_reference")
	private Product fcReference;
	
	@Column(name="fc_quantite")
	private Double fcQuantite;
	
	public BillProduct() {
		
	}

	public BillProduct(int fcId, Bill fcNumero, Product fcReference, Double fcQuantite) {
		this.fcId = fcId;
		this.fcNumero = fcNumero;
		this.fcReference = fcReference;
		this.fcQuantite = fcQuantite;
	}

	public int getFcId() {
		return fcId;
	}

	public void setFcId(int fcId) {
		this.fcId = fcId;
	}

	public Bill getFcNumero() {
		return fcNumero;
	}

	public void setFcNumero(Bill fcNumero) {
		this.fcNumero = fcNumero;
	}

	public Product getFcReference() {
		return fcReference;
	}

	public void setFcReference(Product fcReference) {
		this.fcReference = fcReference;
	}

	public Double getFcQuantite() {
		return fcQuantite;
	}

	public void setFcQuantite(Double fcQuantite) {
		this.fcQuantite = fcQuantite;
	}

	@Override
	public String toString() {
		return "FactureProduit [fcId=" + fcId + ", fcNumero=" + fcNumero + ", fcReference=" + fcReference
				+ ", fcQuantite=" + fcQuantite + "]";
	}

	
}
