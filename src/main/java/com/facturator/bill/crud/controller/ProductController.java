package com.facturator.bill.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.facturator.bill.crud.entity.Product;
import com.facturator.bill.crud.service.ProductService;

@RestController
@RequestMapping("/billing")
public class ProductController {

	// fais le lien avec le service
	
	@Autowired
	private ProductService productService;
	// request body interragit avec le json on le fait dans le controller car c'est la derniere couche 

	// post http://localhost:8080/billing/product
	
	@PostMapping("/product")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Product saveProduit(@RequestBody Product product) {
    Product newProduct = productService.saveProduct(product);
    return newProduct;
	}

	// get http://localhost:8080/billing/listProduct
	
	@GetMapping("/listProduct")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Product> allProduct(){
		List<Product> listAllProduct = productService.allProduct();
		return listAllProduct;
	}
	
	// get http://localhost:8080/billing/listProduct/1
	
	@GetMapping("/listProduct/{pReference}")
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
		public Product findProduct(@PathVariable int pReference) {
		Product newProduct = productService.findProduct(pReference);
		return newProduct;
	}

	// put http://localhost:8080/billing/listProduct/
	
	@PutMapping("/listProduct")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Product updateProduct(@RequestBody Product product) {
		productService.saveProduct(product);
		return product;
	}
	
	// delete http://localhost:8080/billing/product/1

	@DeleteMapping("/listProduct/{pReference}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteProduct(@PathVariable("pReference") int id) {
	productService.deleteProduct(id);

	}

}
