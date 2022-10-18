package com.facturator.bill.crud.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.facturator.bill.crud.dto.BillProductDTO;
import com.facturator.bill.crud.dto.ProductDTO;
import com.facturator.bill.crud.entity.Product;

public class ProductMapper {

	public static ProductDTO toDto (Product prod) {
		ProductDTO dto = null;
		
		if(prod!=null) {
			try {
				dto = new ProductDTO(prod.getpReference(),prod.getpDescription(),prod.getpPrixHT(),prod.getpTauxTVA(),prod.getpRemarque());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public static List<ProductDTO> toDtoListWithBillProduct(List<Product> allProducts){
		List<ProductDTO> prods = null;
		
		if(allProducts!=null && !allProducts.isEmpty()) {
			prods = new ArrayList<>();
			
			for(Product p : allProducts) {
				prods.add(toDtoWithBillProduct(p));
			}
		}
		
		return prods;
	}

	public static ProductDTO toDtoWithBillProduct(Product prod) {
		ProductDTO prodDTO = null;
		
		if(prod!=null) {
			try {
				prodDTO = toDto(prod);
				prodDTO.setBillProducts(BillProductMapper.toDtoList(prod.getBillProducts()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return prodDTO;
	}
	
	public static Product toEntity(ProductDTO prod) {
		Product entity = null;
		
		if(prod!=null) {
			entity = new Product(prod.getpReference(),prod.getpDescription(),prod.getpPrixHT(),prod.getpTauxTVA(),prod.getpRemarque());
		
			if (prod.getBillProducts()!=null && !prod.getBillProducts().isEmpty()) {
				for(BillProductDTO p : prod.getBillProducts()) {
					entity.addBillProduct(BillProductMapper.toEntity(p));
					
				}
			}
		}
		
		return entity;
	}
}














