package br.com.ananiascaetano.application.services.category;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id)
            .orElseThrow(() ->  new EntityNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND));
    }
}
