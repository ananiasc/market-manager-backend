package br.com.ananiascaetano.application.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.application.services.brand.BrandService;
import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {
	private final ProductTypeService productTypeService;
	private final ProductRepository productRepository;
	private final BrandService brandService;

	public List<Product> findAll(){
		return productRepository.findAll();
	}

	public Product findById(Long id) {
		return productRepository.findById(id)
			.orElseThrow(() -> new EntityNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));
	}
	
	public Product createProduct(Product product) {
		productTypeService.findById(product.getTypeId());
		brandService.findById(product.getBrandId());
		
		return productRepository.save(product);
	}

	public Product updateProduct(Product productUpdate) {
		productTypeService.findById(productUpdate.getTypeId());
		brandService.findById(productUpdate.getBrandId());

		Product product = findById(productUpdate.getId());
		productUpdate.setCode(product.getCode());
		
		return productRepository.updateProductById(productUpdate);
	}

	public void deleteProduct(Long id) {
		productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));

		productRepository.deleteById(id);
	}
}
