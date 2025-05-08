package br.com.ananiascaetano.infrastructure.repositories.products_categories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ananiascaetano.domain.products_categories.ProductCategoryId;
import br.com.ananiascaetano.domain.products_categories.ProductsCategories;

public interface ProductsCategoriesRepository extends JpaRepository<ProductsCategories, ProductCategoryId> {
    List<ProductsCategories> findByIdProductId(Long productId);
}
