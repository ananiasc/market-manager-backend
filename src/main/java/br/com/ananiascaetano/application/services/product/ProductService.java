package br.com.ananiascaetano.application.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository repository;
	
	private final ProductTypeService productTypeService;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product createProduct(Product product) {
		productTypeService.findById(product.getType().getId())
				.orElseThrow(() ->  new RuntimeException(ErrorMessages.PRODUCT_TYPE_NOT_FOUND));
		
		return repository.save(product);
	}
}
