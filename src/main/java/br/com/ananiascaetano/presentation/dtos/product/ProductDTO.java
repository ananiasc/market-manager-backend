package br.com.ananiascaetano.presentation.dtos.product;

import java.math.BigDecimal;

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
	
}
