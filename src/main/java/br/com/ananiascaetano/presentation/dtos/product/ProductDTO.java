package br.com.ananiascaetano.presentation.dtos.product;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.domain.entities.product.ProductType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	private String code;
	private String title;
	private String technicalDescription;
	private String longDescription;
	private BigDecimal price;
	private BigDecimal discountedPrice;
	private Boolean isDiscounted;
	private String type;
	private int stock;
	private Boolean isActive;
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.code = product.getCode();
		this.title = product.getTitle();
		this.technicalDescription = product.getTechnicalDescription();
		this.longDescription = product.getLongDescription();
		this.price = product.getPrice();
		this.discountedPrice = product.getDiscountedPrice();
		this.isDiscounted = product.isDiscounted();
		this.type = product.getType().getName();
		this.stock = product.getStock();
		this.isActive = product.isActive();
	}
	
	public Product getProduct(ProductType type) {
		Product product = Product.builder()
						.code(this.code)
						.title(this.title)
						.technicalDescription(this.technicalDescription)
						.longDescription(this.longDescription)
						.price(this.price)
						.discountedPrice(this.discountedPrice)
						.isDiscounted(this.isDiscounted())
						.type(type)
						.stock(this.stock)
						.isActive(this.isActive())
						.build();
		
		return product;
	}
	
	@JsonIgnore
	public boolean isDiscounted() {
		if(this.isDiscounted != null && this.isDiscounted) {
			return true;
		}
		return false;
	}
	
	@JsonIgnore
	public boolean isActive() {
		if(this.isActive != null && this.isActive) {
			return true;
		}
		return false;
	}
}
