package br.com.ananiascaetano.application.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.domain.entities.product.ProductType;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductRepository;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductTypeRepository;
import br.com.ananiascaetano.mappers.product.ProductMapper;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductService {

	private final ProductRepository repository;
	
	private final ProductTypeRepository typeRepository;
	
	private ProductMapper productMapper = new ProductMapper();
	public List<ProductDTO> findAll(){
		List<Product> products = repository.findAll();
		
		return productMapper.convertToEntityDTOList(products);
	}
	
	public Product createProduct(ProductDTO productDTO) {
		ProductType type = typeRepository.findByName(productDTO.getType())
				.orElseThrow(() ->  new RuntimeException("Product type not found"));
		
		Product product = productDTO.getProduct(type);
		
		return repository.save(product);
	}
}
