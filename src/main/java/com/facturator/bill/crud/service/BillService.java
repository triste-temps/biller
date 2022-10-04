package com.facturator.bill.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturator.bill.crud.entity.Facture;
import com.facturator.bill.crud.repository.BillRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository fr;
	
	@Transactional
	public Facture saveBill(Facture fac) {
		
		Facture newBill = fr.save(fac);
		return newBill;
	}
	
	public List<Facture> allBill(){
		List<Facture> allBill = fr.findAll();
		return allBill;
	}
	
	public Facture findBill(int id) {
		Optional<Facture> resultatId = fr.findById(id);
		
		Facture testId = null;
		
		if (resultatId.isPresent()) {
			testId = resultatId.get();
		} else {
			throw new RuntimeException("Je n'ai pas trouvé cette id : " + id);
		
		}
		
		return testId;
	}
	
	public void updateBill (Facture fac, int id) {
		fr.save(fac);
	}
	
	public void deleteBill(int id) {
		fr.deleteById(id);
	}
}
