package br.com.ananiascaetano.infrastructure.repositories.category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ananiascaetano.domain.entities.category.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("SELECT c.id FROM categories c WHERE c.id IN :ids")
    List<Integer> findExistingIds(@Param("ids") List<Integer> ids);
}
