package br.com.ananiascaetano.presentation.controllers.product;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.ananiascaetano.application.services.product.ProductService;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;

@RestController
@RequestMapping("/portal/products")
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping
	public List<ProductDTO> findAll() {
		return productService.findAll().stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());
	}
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return new ProductDTO(productService.createProduct(productDTO));
	}
}
