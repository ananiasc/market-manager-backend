package br.com.ananiascaetano.application.services.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.application.services.brand.BrandService;
import br.com.ananiascaetano.application.services.category.CategoryService;
import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.category.Category;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.expections.EntityAlreadyExistException;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductTypeService productTypeService;
	private final ProductRepository productRepository;
	private final BrandService brandService;
	private final CategoryService categoryService;

	public List<Product> findAll(){
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		return productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
	}
	
	public void createProduct(Product product, List<Category> categories) {
		validateSlugUniqueness(product.getSlug());
		productTypeService.findById(product.getTypeId());
		brandService.findById(product.getBrandId());
		categoryService.validateCategoriesList(categories);

		productRepository.save(product);
	}

	public void updateProduct(Product productUpdate, List<Category> categories) {
		Product product = findById(productUpdate.getId());
		if(product.itsDifferentSlug(productUpdate.getSlug())) {
			validateSlugUniqueness(productUpdate.getSlug());
		}
		productTypeService.findById(productUpdate.getTypeId());
		brandService.findById(productUpdate.getBrandId());
		categoryService.validateCategoriesList(categories);

		productUpdate.setCode(product.getCode());
		
		productRepository.save(productUpdate);
	}

	public void deleteProduct(Long id) {
		findById(id);
		productRepository.deleteById(id);
	}

	private void validateSlugUniqueness(String slug) {
		Optional<Product> productBySlug = productRepository.findBySlug(slug);
		if(productBySlug.isPresent()) {
			throw new EntityAlreadyExistException(ErrorMessages.SLUG_ALREADY_EXIST);
		}
	}
}
