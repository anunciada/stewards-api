package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryCommand;
import br.com.anunciada.stewards_api.application.usecase.category.UpdateCategoryUseCase;
import br.com.anunciada.stewards_api.domain.model.Category;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UpdateCategoryService implements UpdateCategoryUseCase {

    private final CategoryPersistencePort categoryPersistencePort;

    public UpdateCategoryService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void execute(UUID id, CreateCategoryCommand command) {
        Category category = new Category(
                id,
                command.groupId(),
                command.name());

        categoryPersistencePort.update(category);
    }
}
