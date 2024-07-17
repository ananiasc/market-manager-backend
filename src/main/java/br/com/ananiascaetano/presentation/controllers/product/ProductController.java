package br.com.ananiascaetano.presentation.controllers.product;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import br.com.ananiascaetano.application.services.product.ProductService;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.mappers.product.ProductMapper;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	
	private ProductMapper productMapper = new ProductMapper();
	
	private ModelMapper model = new ModelMapper();

	@GetMapping
	public List<ProductDTO> findAll() {
		List<Product> products = productService.findAll();
		return productMapper.convertToEntityDTOList(products);
	}
	
	@PostMapping
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		Product product = this.model.map(productDTO, Product.class);
		
		Product savedProduct =  productService.createProduct(product);
		return this.model.map(savedProduct, ProductDTO.class);
	}
}
