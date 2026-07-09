package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.category.ListCategoriesUseCase;
import br.com.anunciada.stewards_api.domain.model.Category;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListCategoriesService implements ListCategoriesUseCase {

    private final CategoryPersistencePort categoryPersistencePort;

    public ListCategoriesService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public List<Category> execute() {
        return categoryPersistencePort.findAll();
    }
}