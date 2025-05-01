package br.com.ananiascaetano.domain.entities.brand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "brands")
public class Brand {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
}
