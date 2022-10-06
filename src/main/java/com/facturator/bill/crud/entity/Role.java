package com.facturator.bill.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Role {

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id	
	@JoinColumn(name="rol_id")
	private int rId;
	
	@JoinColumn(name="rol_nom")
	private String rNom;
	
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	private List <CompanyRole> CompanyRole;
	
	public Role() {
		
	}

	public Role(int rId, String rNom, List<com.facturator.bill.crud.entity.CompanyRole> companyRole) {
		this.rId = rId;
		this.rNom = rNom;
		CompanyRole = companyRole;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public String getrNom() {
		return rNom;
	}

	public void setrNom(String rNom) {
		this.rNom = rNom;
	}

	public List<CompanyRole> getCompanyRole() {
		return CompanyRole;
	}

	public void setCompanyRole(List<CompanyRole> companyRole) {
		CompanyRole = companyRole;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rNom=" + rNom + ", CompanyRole=" + CompanyRole + "]";
	}
	
}
