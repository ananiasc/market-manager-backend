package br.com.ananiascaetano.presentation.dtos.product;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.ananiascaetano.constants.ValidationMessages;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Long id;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.ATTRIBUTE_IS_NOT_EMPTY)
	private String code;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.ATTRIBUTE_IS_NOT_EMPTY)
	private String title;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.ATTRIBUTE_IS_NOT_EMPTY)
	private String technicalDescription;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.ATTRIBUTE_IS_NOT_EMPTY)
	private String longDescription;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private BigDecimal price;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private BigDecimal discountedPrice;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private boolean discounted;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private Integer typeId;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private int stock;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private boolean active;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.ATTRIBUTE_IS_NOT_EMPTY)
	private String slug;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	private Integer brandId;
	@NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
	@NotEmpty(message = ValidationMessages.LIST_IS_NOT_EMPTY)
	private List<CategoryDTO> categories;
}
