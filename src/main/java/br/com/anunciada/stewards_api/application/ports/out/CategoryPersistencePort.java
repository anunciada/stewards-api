package br.com.anunciada.stewards_api.application.ports.out;

import br.com.anunciada.stewards_api.domain.model.Category;
import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import java.util.List;
import java.util.UUID;

public interface CategoryPersistencePort {

    void save(Category category);

    List<ListCategoryResponse> findAll(UUID groupId);

}