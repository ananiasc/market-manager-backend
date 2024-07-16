package br.com.ananiascaetano.mappers.product;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import br.com.ananiascaetano.domain.entities.product.Product;
import br.com.ananiascaetano.presentation.dtos.product.ProductDTO;

public class ProductMapper {
	private ModelMapper model;
	
	public ProductMapper() {
		this.model = new ModelMapper();
	}
	
	public List<ProductDTO> convertToEntityDTOList(List<Product> products) {
        return products.stream()
                .map(product -> this.model.map(product, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
