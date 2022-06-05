package com.example.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.course.entities.Product;
import com.example.course.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	
	@Autowired
	private ProductService userService;
	
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){
		List<Product> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<Product> findById(@PathVariable Long userId){
		Product obj = userService.findById(userId);
		return ResponseEntity.ok().body(obj);
	}
	
}
