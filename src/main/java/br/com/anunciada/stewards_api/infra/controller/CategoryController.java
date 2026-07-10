package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryCommand;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryUseCase;
import br.com.anunciada.stewards_api.application.usecase.category.ListCategoriesUseCase;
import br.com.anunciada.stewards_api.application.usecase.category.UpdateCategoryUseCase;
import br.com.anunciada.stewards_api.infra.controller.request.CreateCategoryRequest;
import br.com.anunciada.stewards_api.infra.controller.response.ListCategoryResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        private final CreateCategoryUseCase createCategoryUseCase;
        private final ListCategoriesUseCase listCategoriesUseCase;
        private final UpdateCategoryUseCase updateCategoryUseCase;

        public CategoryController(CreateCategoryUseCase createCategoryUseCase,
                                  ListCategoriesUseCase listCategoriesUseCase,
                                  UpdateCategoryUseCase updateCategoryUseCase) {
            this.createCategoryUseCase = createCategoryUseCase;
            this.listCategoriesUseCase = listCategoriesUseCase;
            this.updateCategoryUseCase = updateCategoryUseCase;
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

        @GetMapping("/{groupId}")
        @ResponseStatus(HttpStatus.OK)
        public List<ListCategoryResponse> listCategoryByGroup(@PathVariable UUID groupId) {
            return listCategoriesUseCase.execute(groupId);
        }

        @PutMapping("/{id}")
        @ResponseStatus(HttpStatus.CREATED)
        public void updateCategory(@PathVariable UUID id, @Valid @RequestBody CreateCategoryRequest request) {
            updateCategoryUseCase.execute(id,
                    new CreateCategoryCommand(
                            request.name(),
                            request.groupId()
                    )
            );
        }
}