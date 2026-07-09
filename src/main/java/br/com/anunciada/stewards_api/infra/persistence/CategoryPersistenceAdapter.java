package br.com.anunciada.stewards_api.infra.persistence;

import br.com.anunciada.stewards_api.application.ports.out.CategoryPersistencePort;
import br.com.anunciada.stewards_api.domain.model.Category;
import org.springframework.stereotype.Component;
import java.util.List;

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
    public List<Category> findAll() {
        return repository.findAll()
                .stream()
                .map(entity ->
                        new Category(
                                entity.getId(),
                                entity.getName(),
                                entity.getGroupId()
                        )
                )
                .toList();
    }
}