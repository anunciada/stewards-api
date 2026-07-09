package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryCommand;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryUseCase;
import br.com.anunciada.stewards_api.infra.controller.request.CreateCategoryRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        private final CreateCategoryUseCase createCategoryUseCase;

        public CategoryController(CreateCategoryUseCase createCategoryUseCase) {
            this.createCategoryUseCase = createCategoryUseCase;
        }

        @PostMapping
        @ResponseStatus(HttpStatus.CREATED)
        public void createCategory(@Valid @RequestBody CreateCategoryRequest request) {
            createCategoryUseCase.execute(
                    new CreateCategoryCommand(
                            request.name(),
                            request.groupId()
                    )
            );
        }

}