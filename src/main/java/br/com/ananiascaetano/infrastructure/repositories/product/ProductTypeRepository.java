package br.com.ananiascaetano.infrastructure.repositories.product;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.entities.product.ProductType;

public interface ProductTypeRepository extends JpaRepository<ProductType, Integer> {
	
}
