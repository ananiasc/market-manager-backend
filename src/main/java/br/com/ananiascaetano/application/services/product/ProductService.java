package br.com.ananiascaetano.application.services.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository repository;
	
	private final ProductTypeService productTypeService;
	private final ProductRepository productRepository;

	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product createProduct(Product product) {
		productTypeService.findById(product.getType().getId())
				.orElseThrow(() ->  new EntityNotFoundException(ErrorMessages.PRODUCT_TYPE_NOT_FOUND));
		
		return repository.save(product);
	}

	public Product updateProduct(Product product) {
		productTypeService.findById(product.getType().getId())
				.orElseThrow(() ->  new EntityNotFoundException(ErrorMessages.PRODUCT_TYPE_NOT_FOUND));

		return repository.updateProductById(product);
	}

	public void deleteProduct(Long id) {
		productRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(ErrorMessages.PRODUCT_NOT_FOUND));

		repository.deleteById(id);
	}
}
