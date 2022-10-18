package com.facturator.bill.crud.security.models;

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
@Table(name="entreprise_role")
public class CompanyRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="er_id")
	private int erId;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ent_numero_siret")
	private Company erNumeroSiret;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="rol_id")
	private Role erNumero;
	
	public CompanyRole() {
		
	}

	public CompanyRole(int erId, Company erNumeroSiret, Role erNumero) {
		this.erId = erId;
		this.erNumeroSiret = erNumeroSiret;
		this.erNumero = erNumero;
	}

	public int getErId() {
		return erId;
	}

	public void setErId(int erId) {
		this.erId = erId;
	}

	public Company getErNumeroSiret() {
		return erNumeroSiret;
	}

	public void setErNumeroSiret(Company erNumeroSiret) {
		this.erNumeroSiret = erNumeroSiret;
	}

	public Role getErNumero() {
		return erNumero;
	}

	public void setErNumero(Role erNumero) {
		this.erNumero = erNumero;
	}

	@Override
	public String toString() {
		return "CompanyRole [erId=" + erId + ", erNumeroSiret=" + erNumeroSiret + ", erNumero=" + erNumero + "]";
	}
}