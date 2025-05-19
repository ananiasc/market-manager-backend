package br.com.ananiascaetano.application.services.products_categories;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.domain.entities.category.Category;
import br.com.ananiascaetano.domain.products_categories.ProductsCategories;
import br.com.ananiascaetano.infrastructure.repositories.products_categories.ProductsCategoriesRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsCategoriesService {
    private final ProductsCategoriesRepository productsCategoriesRepository;

    public List<ProductsCategories> findByProductId(Long id) {
        return productsCategoriesRepository.findByIdProductId(id);
    }

    public void createProductsCategoriesByProducIdAndCategories(Long productId, List<Category> categories) {
        categories.forEach(
            category -> createProductsCategories(new ProductsCategories(productId, category.getId()))
        );
    }

    private void createProductsCategories(ProductsCategories productsCategories) {
        productsCategoriesRepository.save(productsCategories);
    }

    public void deleteOldLinksAndCreateNewOnes(Long productId, List<Category> categories) {
        deleteByProductId(productId);
        categories.forEach(
            category -> createProductsCategories(new ProductsCategories(productId, category.getId()))
        );
    }

    private void deleteByProductId(Long productId) {
        productsCategoriesRepository.deleteByProductId(productId);
    }
}
