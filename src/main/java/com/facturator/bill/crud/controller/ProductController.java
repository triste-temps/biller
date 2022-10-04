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

import com.facturator.bill.crud.entity.Customer;
import com.facturator.bill.crud.entity.Product;
import com.facturator.bill.crud.service.ProductService;

@RestController
@RequestMapping("/facturation")
public class ProductController {

@Autowired
private ProductService ps;
// request body interragi avec le json on le fait dans le controller car c'est la derniere couche 

@PostMapping("/produit")
//http://localhost:8080/test/produit
public Product saveProduit(@RequestBody Product pro) {
    Product newProduct = ps.saveProduct(pro);
    return newProduct;
}

@GetMapping("/listeproduit")

public List<Product> allProduct(){
	List<Product> listAllProduct = ps.allProduct();
	return listAllProduct;
}
	
@GetMapping("/listeproduit/{pReference}")

public Product findProduct(@PathVariable int pReference) {
	Product newProduct = ps.findProduct(pReference);
	return newProduct;
}

@PutMapping("/listeproduit")
public Product updateProduct(@RequestBody Product pro) {
	ps.saveProduct(pro);
	return pro;
}

@DeleteMapping("/listeproduit/{pReference}")
public void deleteProduct(@PathVariable("pReference") int id) {
	//supprimer produit
	ps.deleteProduct(id);

}

}

