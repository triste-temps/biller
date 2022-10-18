package com.facturator.bill.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.dto.BillProductDTO;
import com.facturator.bill.crud.dto.mapper.BillProductMapper;
import com.facturator.bill.crud.entity.BillProduct;
import com.facturator.bill.crud.service.BillProductService;

@RestController
@RequestMapping("/billing")
public class BillProductController {

	@Autowired
	private BillProductService billProductService;
	
//	@PostMapping("/billProduct")
//	public BillProduct saveBillProduct(@RequestBody BillProduct billProduct) {
//		BillProduct newBillProduct = billProductService.saveBillProduct(billProduct);
//		return newBillProduct;
//	}
	
	@GetMapping("/listBillProduct")
	public List<BillProductDTO> allBillProduct(){
		return BillProductMapper.toDtoList(billProductService.allBillProduct());
	}
	
	@GetMapping("/listBillProduct/{fcId}")
	public BillProductDTO findBillProduct(@PathVariable int fcId) {
	BillProductDTO newBillProduct = BillProductMapper.toDto(billProductService.findBillProduct(fcId));
	return newBillProduct;
	}
	
//	@PutMapping("/listBillProduct")
//	public BillProduct updateBillProduct(@RequestBody BillProduct billProduct) {
//		billProductService.saveBillProduct(billProduct);
//		return billProduct;
//	}
//	
//	@DeleteMapping("/listBillProduct/{fcId}")
//	public void deleteBillProduct(@PathVariable("fcId") int id) {
//		billProductService.deleteBillProduct(id);
//	}
	
}