package com.facturator.bill.crud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.facturator.bill.crud.entity.Product;
import com.facturator.bill.crud.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository pr;
		
	@Transactional
    public Product saveProduct(Product pro) {
    
        Product newProduct = pr.save(pro);
        return newProduct;
	
	}
	
	public List<Product> allProduct(){
		
		List<Product> allProduct = pr.findAll();
		return allProduct;
	}
	
	public Product findProduct(int id) {
		Optional<Product> resultatId = pr.findById(id);
		
		Product testId = null;
		
		if (resultatId.isPresent()) {
			testId = resultatId.get();
		} else {
			throw new RuntimeException("Je n'ai pas trouvé cette id : " + id);
		
		}
		
		return testId;
	}
	
	public void updateProduct (Product pro, int id) {
		pr.save(pro);
	}
	
	public void deleteProduct(int id) {
		pr.deleteById(id);
	}
	
}