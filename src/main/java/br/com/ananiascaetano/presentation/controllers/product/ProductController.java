package br.com.ananiascaetano.presentation.controllers.product;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.ananiascaetano.application.services.product.ProductService;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;

	@GetMapping
	public List<ProductDTO> findAll() {
		return productService.findAll();
	}
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);
	}
}
