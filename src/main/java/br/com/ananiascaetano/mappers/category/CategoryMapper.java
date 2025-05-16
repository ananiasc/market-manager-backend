package br.com.ananiascaetano.mappers.category;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.ananiascaetano.domain.entities.category.Category;
import br.com.ananiascaetano.domain.products_categories.ProductsCategories;
import br.com.ananiascaetano.presentation.dtos.product.CategoryDTO;

public class CategoryMapper {
    private ModelMapper model;

    public CategoryMapper() {
        this.model =  new ModelMapper();
    }

    public List<Category> convertDTOToEntityList(List<CategoryDTO> categoriesDTO) {
        return categoriesDTO.stream()
            .map(category -> this.model.map(category, Category.class))
            .collect(Collectors.toList());
    }

    public List<CategoryDTO> convertProductsCategoriesToCategoriesDTOList(List<ProductsCategories> productsCategories) {
        return productsCategories.stream()
            .map(productCategory -> convertProductCategoryToCategory(productCategory))
            .collect(Collectors.toList());
    }

    public CategoryDTO convertProductCategoryToCategory(ProductsCategories productCategory) {
        CategoryDTO category = new CategoryDTO();
        category.setId(productCategory.getId().getCategoryId());
        
        return category;
    }
}
