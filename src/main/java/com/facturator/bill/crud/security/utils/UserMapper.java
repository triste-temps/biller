package com.facturator.bill.crud.security.utils;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.facturator.bill.crud.security.models.Company;

public class UserMapper  {
	public static UserPrincipal userToPrincipal(Company company) {
		UserPrincipal userp = new UserPrincipal();
		List<SimpleGrantedAuthority> authorities = company.getCompanyRoles().stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + company.getCompanyRoles())).collect(Collectors.toList());
		System.err.println(company.getCompanyRoles());
		userp.setUsername(company.geteNomUtilisateur());
		userp.setPassword(company.geteMDP());
		userp.setEnabled(true);
		userp.setAuthorities(authorities);
		return userp;
	}
	
}