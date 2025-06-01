package br.com.ananiascaetano.presentation.controllers.product;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import br.com.ananiascaetano.application.services.product.ProductService;
import br.com.ananiascaetano.application.services.products_categories.ProductsCategoriesService;
import br.com.ananiascaetano.domain.entities.category.Category;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.domain.products_categories.ProductsCategories;
import br.com.ananiascaetano.mappers.category.CategoryMapper;
import br.com.ananiascaetano.mappers.product.ProductMapper;
import br.com.ananiascaetano.presentation.dtos.product.CategoryDTO;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;
import br.com.ananiascaetano.presentation.dtos.product.ProductUpdateDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService productService;
	private ProductMapper productMapper = new ProductMapper();
	private ModelMapper model = new ModelMapper();
	private CategoryMapper categoryMapper = new CategoryMapper();
	private final ProductsCategoriesService productsCategoriesService;

	// Criar findByFilter
	// Simplificar findAll
	@GetMapping
	public List<ProductDTO> findAll() {
		List<Product> products = productService.findAll();
		return productMapper.convertToEntityDTOList(products);
	}

	@GetMapping("/{id}")
	public ProductDTO findById(@PathVariable Long id) {
		Product product = productService.findById(id);
		List<ProductsCategories> productsCategories = productsCategoriesService.findByProductId(product.getId());
		ProductDTO productDTO = model.map(product, ProductDTO.class);
		List<CategoryDTO> categories = categoryMapper.convertProductsCategoriesToCategoriesDTOList(productsCategories);
		productDTO.setCategories(categories);
		return productDTO;
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@Valid @RequestBody ProductDTO productDTO) {
		Product product = this.model.map(productDTO, Product.class);
		List<Category> categories = categoryMapper.convertDTOToEntityList(productDTO.getCategories());
		Product productCreated = productService.createProduct(product, categories);
		// Vincular categoria pai das subcategorias
		productsCategoriesService.createProductsCategoriesByProducIdAndCategories(productCreated.getId(), categories);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@PutMapping
	public void updateProduct(@Valid @RequestBody ProductUpdateDTO productDTO) {
		Product product = this.model.map(productDTO, Product.class);
		List<Category> categories = categoryMapper.convertDTOToEntityList(productDTO.getCategories());
		Product productUpdated = productService.updateProduct(product, categories);
		// Vincular categoria pai das subcategorias
		productsCategoriesService.deleteOldLinksAndCreateNewOnes(productUpdated.getId(), categories);
	}

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable Long id) {
		productsCategoriesService.deleteByProductId(id);
		productService.deleteProduct(id);
	}
}
