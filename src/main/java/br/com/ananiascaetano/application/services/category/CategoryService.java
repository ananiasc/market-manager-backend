package br.com.ananiascaetano.application.services.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.category.Category;
import br.com.ananiascaetano.expections.EntityNotFoundException;
import br.com.ananiascaetano.infrastructure.repositories.category.CategoryRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public void validateCategoriesList(List<Category> categories) {
        List<Integer> ids = categories.stream()
                                .map(category -> category.getId())
                                .collect(Collectors.toList());
        
        List<Category> existingCategories = categoryRepository.findByIdIn(ids);

        List<Integer> existingIds = existingCategories.stream()
        .map(category -> category.getId())
        .collect(Collectors.toList());

        if(Category.hasCatogoryIdWithoutRegistration(ids, existingIds)) {
            throw new EntityNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND);
        }
    }

    public Category findById(Integer id) {
        return categoryRepository.findById(id)
            .orElseThrow(() ->  new EntityNotFoundException(ErrorMessages.CATEGORY_NOT_FOUND));
    }
}
