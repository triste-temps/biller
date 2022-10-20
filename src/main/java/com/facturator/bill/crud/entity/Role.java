/*package com.facturator.bill.crud.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private String rNom;
	
	@OneToMany(mappedBy = "erNumero", cascade = CascadeType.ALL)
	private List <CompanyRole> companyRoles;
	
	public Role() {
		
	}

	public Role(int rId, String rNom, List<CompanyRole> companyRoles) {
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

	public String getrNom() {
		return rNom;
	}

	public void setrNom(String rNom) {
		this.rNom = rNom;
	}

	public List<CompanyRole> getCompanyRoles() {
		return companyRoles;
	}

	public void setCompanyRoles(List<CompanyRole> companyRoles) {
		this.companyRoles = companyRoles;
	}

	@Override
	public String toString() {
		return "Role [rId=" + rId + ", rNom=" + rNom + ", companyRoles=" + companyRoles + "]";
	}

}
*/