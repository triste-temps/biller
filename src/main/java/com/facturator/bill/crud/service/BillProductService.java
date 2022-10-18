package com.facturator.bill.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturator.bill.crud.entity.BillProduct;
import com.facturator.bill.crud.repository.BillProductRepository;

@Service
public class BillProductService {

	@Autowired
	private BillProductRepository fpr;
	
	@Transactional
	public BillProduct saveBillProduct(BillProduct fp) {
		
		BillProduct newBillProduct = fpr.save(fp);
		return newBillProduct;
	}
	
	public List <BillProduct> allBillProduct(){
		
		List<BillProduct> allBillProduct = fpr.findAll();
		return allBillProduct;
	}
	
	public BillProduct findBillProduct(int id) {
		Optional<BillProduct> resultatId = fpr.findById(id);
		
		BillProduct testId = null;
		
		if (resultatId.isPresent()) {
			testId = resultatId.get();
		} else {
			throw new RuntimeException("Je n'ai pas trouvé cette id : " + id);
		
		}
		
		return testId;
	}
	
	public void updateBillProduct (BillProduct fp, int id) {
		fpr.save(fp);
	}
	
	public void deleteBillProduct(int id) {
		fpr.deleteById(id);
	}
}