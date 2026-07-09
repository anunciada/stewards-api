package br.com.anunciada.stewards_api.application.service;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryCommand;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryUseCase;
import br.com.anunciada.stewards_api.domain.model.Category;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class CreateCategoryService implements CreateCategoryUseCase {

    private final CategoryPersistencePort categoryPersistencePort;

    public CreateCategoryService(CategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void execute(CreateCategoryCommand command) {
        Category category = new Category(
                UUID.randomUUID(),
                command.name(),
                command.groupId());

        categoryPersistencePort.save(category);
    }
}