package com.facturator.bill.crud.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produit")
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pro_reference")
	private int pReference;
	
	@Column(name="pro_description")
	private String pDescription;
	
	@Column(name="pro_prix_ht")
	private Double pPrixHT;
	
	@Column(name="pro_taux_tva")
	private Double pTauxTVA;
	
	@Column(name="pro_remarque")
	private String pRemarque;
	

	@OneToMany(mappedBy = "fcReference", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List <BillProduct> billProducts;
	
	public Product() {
		
	}

	public Product(int pReference, String pDescription, Double pPrixHT, Double pTauxTVA, String pRemarque) {
		this.pReference = pReference;
		this.pDescription = pDescription;
		this.pPrixHT = pPrixHT;
		this.pTauxTVA = pTauxTVA;
		this.pRemarque = pRemarque;
	}

	public void addBillProduct(BillProduct billProduct) {

		if (billProducts==null) {
			billProducts = new ArrayList<>();
		}
		billProduct.setFcReference(this);
		this.billProducts.add(billProduct);
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

	public List<BillProduct> getBillProducts() {
		return billProducts;
	}

	public void setBillProducts(List<BillProduct> billProducts) {
		this.billProducts = billProducts;
	}

	@Override
	public String toString() {
		return "Product [pReference=" + pReference + ", pDescription=" + pDescription + ", pPrixHT=" + pPrixHT
				+ ", pTauxTVA=" + pTauxTVA + ", pRemarque=" + pRemarque + ", billProducts=" + billProducts + "]";
	}
	
}