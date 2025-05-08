package br.com.ananiascaetano.domain.products_categories;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import br.com.ananiascaetano.constants.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryId implements Serializable {
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "category_id")
    private Integer categoryId;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        
        ProductCategoryId that = (ProductCategoryId) object;
        
        if (!productId.equals(that.productId)) return false;
        return categoryId.equals(that.categoryId);
    }

    @Override
    public int hashCode() {
        int result = productId.hashCode();
        result = Constants.primeNumber * result + categoryId.hashCode();
        return result;
    }
}