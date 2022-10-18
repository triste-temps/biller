package com.facturator.bill.crud.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.facturator.bill.crud.dto.BillDTO;
import com.facturator.bill.crud.dto.CustomerDTO;
import com.facturator.bill.crud.entity.Customer;



public class CustomerMapper {

	public static CustomerDTO toDto(Customer cust) {
		CustomerDTO dto = null;

		if(cust!=null) {
			try {
				dto = new CustomerDTO(cust.getcNumero(), cust.getcType(), cust.getcNomPrenomRaisonSociale(), cust.getcAdresse(),
						cust.getcCodePostal(), cust.getcVille(), cust.getcTelephoneMobile(), cust.getcTelephoneFixe(), cust.getcSiteInternet(), cust.getcEmail());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return dto;
	}
	
	public static List<CustomerDTO> toDtoListWithBill(List<Customer> allCustomers) {
		List<CustomerDTO> custs = null;

		if(allCustomers!=null && !allCustomers.isEmpty()) {
			custs = new ArrayList<>();

			for(Customer b : allCustomers) {
				custs.add(toDtoWithBill(b));
			}
		}

		return custs;
	}
	
	
	public static CustomerDTO toDtoWithBill(Customer cust) {
		CustomerDTO custDTO = null;
		
		if(cust!=null) {
			try {
				custDTO = toDto(cust);
				custDTO.setBills(BillMapper.toDtoList(cust.getBills()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return custDTO;
	}

	public static Customer toEntity(CustomerDTO cust) {
		Customer entity = null;

		if(cust!=null) {
			entity = new Customer(cust.getcNumero(), cust.getcType(), cust.getcNomPrenomRaisonSociale(), cust.getcAdresse(),
					cust.getcCodePostal(), cust.getcVille(), cust.getcTelephoneMobile(), cust.getcTelephoneFixe(), cust.getcSiteInternet(), cust.getcEmail());

			if (cust.getBills()!=null && !cust.getBills().isEmpty()) {
				for(BillDTO b : cust.getBills()) {
					entity.addBill(BillMapper.toEntity(b));
				}
			}

		}

		return entity;
	}
}
