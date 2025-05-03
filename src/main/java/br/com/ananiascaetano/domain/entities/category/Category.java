package br.com.ananiascaetano.domain.entities.category;

import java.util.List;

import javax.persistence.Column;
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
@Table(name = "categories")
public class Category {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Column(name = "parent_category_id")
    private Integer parentCategoryId;

    public static boolean hasCatogoryIdWithoutRegistration(List<Integer> idsToValidate, List<Integer> existingIds) {
        List<Integer> idsNotFound = idsToValidate;
        idsNotFound.removeAll(existingIds);

        if(idsNotFound.isEmpty()) {
            return false;
        }

        return true;
    }
}
