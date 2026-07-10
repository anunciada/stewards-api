package br.com.anunciada.stewards_api.application.usecase.category;

import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import java.util.List;
import java.util.UUID;

public interface ListCategoriesUseCase {

    List<ListCategoryResponse> execute(UUID groupId);

}