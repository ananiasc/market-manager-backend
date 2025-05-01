package br.com.ananiascaetano.presentation.controllers.product;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
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

	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		return model.map(product, ProductDTO.class);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
		Product product = this.model.map(productDTO, Product.class);
		
		Product savedProduct =  productService.createProduct(product);
		return this.model.map(savedProduct, ProductDTO.class);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public void updateProduct(@RequestBody ProductDTO productDTO) {
		Product product = this.model.map(productDTO, Product.class);
		productService.updateProduct(product);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productService.deleteProduct(id);
	}
}
