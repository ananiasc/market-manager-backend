package br.com.ananiascaetano.presentation.dtos.product;

import javax.validation.constraints.NotNull;

import br.com.ananiascaetano.constants.ValidationMessages;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductUpdateDTO extends ProductDTO {
    @NotNull(message = ValidationMessages.ATTRIBUTE_IS_NOT_NULL)
    private Long id;
}
