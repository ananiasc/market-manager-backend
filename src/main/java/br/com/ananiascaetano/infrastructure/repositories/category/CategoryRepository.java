package br.com.ananiascaetano.infrastructure.repositories.category;

import java.util.Locale.Category;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
