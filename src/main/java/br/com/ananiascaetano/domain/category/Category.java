package br.com.ananiascaetano.domain.category;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "categories")
public class Category {
    private Integer id;
    private String name;
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;
}
