package br.com.ananiascaetano.application.services.products_categories;

import java.util.List;

import org.springframework.stereotype.Service;

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
}
