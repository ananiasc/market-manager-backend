package br.com.ananiascaetano.infrastructure.repositories.product;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.entities.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findBySlug(String slug);
}
