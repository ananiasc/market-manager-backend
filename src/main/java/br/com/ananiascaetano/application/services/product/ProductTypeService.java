package br.com.ananiascaetano.application.services.product;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.domain.entities.product.ProductType;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductTypeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductTypeService {
	private final ProductTypeRepository typeRepository;
	
	public Optional<ProductType> findById(Integer id) {
		return typeRepository.findById(id);
	}
}
