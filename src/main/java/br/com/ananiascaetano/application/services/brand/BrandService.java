package br.com.ananiascaetano.application.services.brand;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import br.com.ananiascaetano.constants.ErrorMessages;
import br.com.ananiascaetano.domain.entities.brand.Brand;
import br.com.ananiascaetano.infrastructure.repositories.brand.BrandRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BrandService {
    private final BrandRepository brandRepository;

    public Brand findById(Integer id) {
        return brandRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException(ErrorMessages.BRAND_NOT_FOUND));
    }
}
