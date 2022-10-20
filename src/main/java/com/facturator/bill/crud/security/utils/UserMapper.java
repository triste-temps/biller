package com.facturator.bill.crud.security.utils;

import com.facturator.bill.crud.security.models.Company;

public class UserMapper {
	public static UserPrincipal userToPrincipal(Company company) {
		UserPrincipal userp = new UserPrincipal();

		// System.err.println(company.getCompanyRoles());
		userp.setUsername(company.getEmail());
		userp.setPassword(company.geteMDP());

		return userp;
	}

}