package br.com.ananiascaetano.infrastructure.repositories.products_categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.ananiascaetano.domain.products_categories.ProductCategoryId;
import br.com.ananiascaetano.domain.products_categories.ProductsCategories;

public interface ProductsCategoriesRepository extends JpaRepository<ProductsCategories, ProductCategoryId> {
    List<ProductsCategories> findByIdProductId(Long productId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductsCategories pc WHERE pc.id.productId = :productId")
    void deleteByProductId(@Param("productId") Long productId);
}
