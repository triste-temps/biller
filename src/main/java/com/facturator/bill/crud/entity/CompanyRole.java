package com.facturator.bill.crud.entity;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="entreprise_role")
public class CompanyRole {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="er_id")
	private int erId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@Column(name="ent_numero_siret")
	private BigInteger erNumeroSiret;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@Column(name="rol_id")
	private int erNumero;
	
	public CompanyRole() {
		
	}

	public CompanyRole(int erId, BigInteger erNumeroSiret, int erNumero) {
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

	public BigInteger getErNumeroSiret() {
		return erNumeroSiret;
	}

	public void setErNumeroSiret(BigInteger erNumeroSiret) {
		this.erNumeroSiret = erNumeroSiret;
	}

	public int getErNumero() {
		return erNumero;
	}

	public void setErNumero(int erNumero) {
		this.erNumero = erNumero;
	}

	@Override
	public String toString() {
		return "CompanyRole [erId=" + erId + ", erNumeroSiret=" + erNumeroSiret + ", erNumero=" + erNumero + "]";
	}

}
