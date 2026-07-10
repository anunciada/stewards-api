package br.com.anunciada.stewards_api.application.usecase.category;

import java.util.UUID;

public interface UpdateCategoryUseCase {

    void execute(UUID id, CreateCategoryCommand command);
}
