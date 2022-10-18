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
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fc_id")
	private int fcId;
		
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="pro_reference")
	private Bill fcNumero;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="fac_numero")
	private Product fcReference;
	
	public BillProduct() {
		
	}

	public BillProduct(int fcId, Bill fcNumero, Product fcReference) {
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

	@Override
	public String toString() {
		return "BillProduct [fcId=" + fcId + ", fcNumero=" + fcNumero + ", fcReference=" + fcReference + "]";
	}
	
}