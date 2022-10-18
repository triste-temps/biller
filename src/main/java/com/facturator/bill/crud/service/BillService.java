package com.facturator.bill.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturator.bill.crud.entity.Bill;
import com.facturator.bill.crud.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository fr;
	
	@Transactional
	public Bill saveBill(Bill fac) {
		
		Bill newBill = fr.save(fac);
		return newBill;
	}
	
	public List<Bill> allBill(){
		List<Bill> allBill = fr.findAll();
		return allBill;
	}
	
	public Bill findBill(int id) {
		Optional<Bill> resultatId = fr.findById(id);
		
		Bill testId = null;
		
		if (resultatId.isPresent()) {
			testId = resultatId.get();
		} else {
			throw new RuntimeException("Je n'ai pas trouvé cette id : " + id);
		
		}
		
		return testId;
	}
	
	public void updateBill (Bill fac, int id) {
		fr.save(fac);
	}
	
	public void deleteBill(int id) {
		fr.deleteById(id);
	}
}