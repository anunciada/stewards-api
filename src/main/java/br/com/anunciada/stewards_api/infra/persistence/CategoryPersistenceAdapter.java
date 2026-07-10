package br.com.anunciada.stewards_api.infra.persistence;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.domain.model.Category;
import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    private final CategoryRepository repository;

    public CategoryPersistenceAdapter(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Category category) {
        repository.save(
                new CategoryEntity(
                        category.getId(),
                        category.getName(),
                        category.getGroupId()
                )
        );
    }

    @Override
    public List<ListCategoryResponse> findAll(UUID groupId) {
        return repository.findAllByGroupId(groupId)
                .stream()
                .map(entity ->
                        new ListCategoryResponse(
                                entity.getName(),
                                entity.getGroupId()
                        )
                )
                .toList();
    }
}