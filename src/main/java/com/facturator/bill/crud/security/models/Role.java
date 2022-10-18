package com.facturator.bill.crud.security.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JoinColumn(name="rol_id")
	private int rId;
	
	@JoinColumn(name="rol_nom")
	private RoleName rNom;
	
	@OneToMany(mappedBy = "erNumero", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private Set <CompanyRole> companyRoles;
	
	public Role() {
		
	}

	public Role(int rId, RoleName rNom, Set<CompanyRole> companyRoles) {
		this.rId = rId;
		this.rNom = rNom;
		this.companyRoles = companyRoles;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public RoleName getrNom() {
		return rNom;
	}

	public void setrNom(RoleName rNom) {
		this.rNom = rNom;
	}

	public Set<CompanyRole> getCompanyRoles() {
		return companyRoles;
	}

	public void setCompanyRoles(Set<CompanyRole> companyRoles) {
		this.companyRoles = companyRoles;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rNom=" + rNom + ", companyRoles=" + companyRoles + "]";
	}


}
