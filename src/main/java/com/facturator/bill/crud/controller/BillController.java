package com.facturator.bill.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.dto.BillDTO;
import com.facturator.bill.crud.dto.mapper.BillMapper;
import com.facturator.bill.crud.service.BillService;

@RestController
@RequestMapping("/billing")
public class BillController {

	@Autowired
	private BillService billService;
	
	// ajouter
	@PostMapping("/bill")
	public BillDTO saveBill(@RequestBody BillDTO bill) {
	return BillMapper.toDtoWithBillProduct(billService.saveBill(BillMapper.toEntity(bill)));
	}
	// obtenir
	@GetMapping("/listBill")
	public List<BillDTO> allBill(){
	return BillMapper.toDtoListWithBillProduct(billService.allBill());
	}
	
	@GetMapping("/listBill/{fNumero}")
	public BillDTO findBill(@PathVariable int fNumero) {
		BillDTO newBill = BillMapper.toDtoWithBillProduct(billService.findBill(fNumero));
		return newBill;
	}
	
	@PutMapping("/listBill")
	public BillDTO updateBill(@RequestBody BillDTO bill) {
		if(bill.getfNumero()!=0) {
			return saveBill(bill);
		}
		return bill;
	}
	
	@DeleteMapping("/listBill/{fNumero}")
	public void deleteBill(@PathVariable("fNumero") int id) {
		billService.deleteBill(id);
	}
}