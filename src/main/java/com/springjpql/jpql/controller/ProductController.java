package com.springjpql.jpql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springjpql.jpql.model.Product;
import com.springjpql.jpql.model.SearchInput;
import com.springjpql.jpql.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository  productRepository;
	
	@GetMapping("/products")
	public List< Product > getAllProducts(){
		return (List<Product>) productRepository.findAll();
	}
	
	@PostMapping("/products")
	public Product createProduct(@Validated @RequestBody Product product) {

        return productRepository.save(product);
    }
    	
	@GetMapping("/findSimilarProductsByName/{name}")
	public List< Product > findSimilarProductsByName(@PathVariable(value = "name") String name){
		 System.out.println("name" + name);
//		return (List<Product>) productRepository.findAll();
		return (List<Product>) productRepository.findSimilarProductsByName( name);
	}
	
	@PostMapping("/search")
	public List< Product > searchByInput(@Validated @RequestBody SearchInput searchInput ){
		System.out.println("getColumn " + searchInput.getColumn());
		return (List<Product>) productRepository.searchProducts(searchInput.getColumn(), searchInput.getValue());
		
	}
}
