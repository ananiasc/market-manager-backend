package br.com.ananiascaetano.application.services.product;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.product.ProductType;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.product.ProductTypeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProductTypeService {
	private final ProductTypeRepository typeRepository;
	
	public ProductType findById(Integer id) {
		return typeRepository.findById(id)
			.orElseThrow(() ->  new EntityNotFoundException(ErrorMessages.PRODUCT_TYPE_NOT_FOUND));
	}
}
