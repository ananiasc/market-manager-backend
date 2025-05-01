package br.com.ananiascaetano.infrastructure.repositories.brand;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.entities.brand.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
