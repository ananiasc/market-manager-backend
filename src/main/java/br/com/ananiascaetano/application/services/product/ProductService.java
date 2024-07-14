package br.com.ananiascaetano.application.services.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.domain.entities.product.ProductType;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductTypeRepository;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;

@Service
public class ProductService {
	@Autowired
	ProductRepository repository;
	
	@Autowired
	ProductTypeRepository typeRepository;
	
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	public Product createProduct(ProductDTO productDTO) {
		ProductType type = typeRepository.findByName(productDTO.getType())
				.orElseThrow(() ->  new RuntimeException("Product type not found"));
		
		Product product = productDTO.getProduct(type);
		
		return repository.save(product);
	}
}
