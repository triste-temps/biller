package com.facturator.bill.crud.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.facturator.bill.crud.dto.BillProductDTO;
import com.facturator.bill.crud.entity.BillProduct;

public class BillProductMapper {

	public static BillProductDTO toDto(BillProduct bp) {
		BillProductDTO dto = null;
		
		if (bp!=null) {
			dto = new BillProductDTO(bp.getFcId(), bp.getFcQuantite(), BillMapper.toDto(bp.getFcNumero()), ProductMapper.toDto(bp.getFcReference()));
		}
		
		return dto;
	}
	
	public static List<BillProductDTO> toDtoList(List<BillProduct> BillProducts) {
		List<BillProductDTO> billProductDTOs = null;
		
		if(BillProducts!=null && !BillProducts.isEmpty()) {
			billProductDTOs = new ArrayList<>();
			for(BillProduct bp : BillProducts) {
				billProductDTOs.add(toDto(bp));
			}
		}
		
		return billProductDTOs;
	}
	
	public static BillProduct toEntity(BillProductDTO dto) {
		BillProduct bp = null;
		
		if (dto!=null) {
			bp = new BillProduct(dto.getFcId(), dto.getFcQuantite(), BillMapper.toEntity(dto.getFcNumero()), ProductMapper.toEntity(dto.getFcReference()));
		}
		
		return bp;
	}
	
}
