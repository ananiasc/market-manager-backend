package br.com.ananiascaetano.domain.entities.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String code;
	private String title;
	@Column(name = "technical_description")
	private String technicalDescription;
	@Column(name = "long_description")
	private String longDescription;
	private BigDecimal price;
	@Column(name = "discounted_price")
	private BigDecimal discountedPrice;
	@Column(name = "is_discounted")
	private boolean discounted;
	
	@ManyToOne
	@JoinColumn(name = "type_id")
	private ProductType type;
	private int stock;
	@Column(name = "is_active")
	private boolean active;
}
