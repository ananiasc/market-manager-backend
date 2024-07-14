package br.com.ananiascaetano.infrastructure.repositories.product;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
