package br.com.ananiascaetano.domain.products_categories;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products_categories")
public class ProductsCategories {
    @EmbeddedId
    private ProductCategoryId id;

    public ProductsCategories(Long productId, Integer categoryId) {
        this.id = new ProductCategoryId(productId, categoryId);
    }
}
