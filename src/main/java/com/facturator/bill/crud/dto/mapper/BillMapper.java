package com.facturator.bill.crud.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.facturator.bill.crud.dto.BillDTO;
import com.facturator.bill.crud.entity.Bill;

public class BillMapper {

	public static BillDTO toDto(Bill bill) {
		BillDTO dto = null;
		
		if (bill!=null) {
			dto = new BillDTO(bill.getfNumero(),bill.getfBonDeCommande(),bill.getfDateEcheance(),bill.getfDateEcheance(),bill.getfPaiementRecu(), bill.getfQuantiteProduit(),bill.getfReglement(),bill.getfPourcentageRemise(),bill.getfTVA(), CustomerMapper.toDto(bill.getFk_cNumero())); 
		}
		
		return dto;
	}
	
	public static List<BillDTO> toDtoListWithBillProduct(List<Bill> allBills) {
		List<BillDTO> bills = null;
		
		if(allBills!=null && !allBills.isEmpty()) {
			bills = new ArrayList<>();
			
			for (Bill b : allBills) {
				bills.add(toDtoWithBillProduct(b));
			}
		}
		
		return bills;
	}
	
	public static BillDTO toDtoWithBillProduct(Bill bill) {
		BillDTO billDTO = null;
		
		if(bill!=null) {
			try {
				billDTO = toDto(bill);
				billDTO.setBillProducts(BillProductMapper.toDtoList(bill.getBillProducts()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return billDTO;
	}
	
	public static List<BillDTO> toDtoList(List<Bill> Bills) {
		List<BillDTO> billDTOs = null;
		
		if(Bills!=null && !Bills.isEmpty()) {
			billDTOs = new ArrayList<>();
			for(Bill b : Bills) {
				billDTOs.add(toDto(b));
			}
		}
		
		return billDTOs;
	}

	public static Bill toEntity(BillDTO dto) {
		Bill bill = null;
		
		if(dto!=null) {
			bill = new Bill(dto.getfNumero(),dto.getfBonDeCommande(),dto.getfDateEcheance(),dto.getfDateEcheance(),dto.getfPaiementRecu(),dto.getfQuantiteProduit(),dto.getfReglement(),dto.getfPourcentageRemise(),dto.getfTVA(), CustomerMapper.toEntity(dto.getFk_cNumero())); 
		}
		
		return bill;
	}
}
