package br.com.ananiascaetano.infrastructure.repositories.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.entities.category.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Integer> findByIdIn(List<Integer> ids);
}
