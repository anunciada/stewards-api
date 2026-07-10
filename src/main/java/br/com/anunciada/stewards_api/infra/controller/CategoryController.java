package br.com.anunciada.stewards_api.infra.controller;

import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryCommand;
import br.com.anunciada.stewards_api.application.usecase.category.CreateCategoryUseCase;
import br.com.anunciada.stewards_api.application.usecase.category.ListCategoriesUseCase;
import br.com.anunciada.stewards_api.domain.model.Category;
import br.com.anunciada.stewards_api.infra.controller.request.CreateCategoryRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

        private final CreateCategoryUseCase createCategoryUseCase;
        private final ListCategoriesUseCase listCategoriesUseCase;

        public CategoryController(CreateCategoryUseCase createCategoryUseCase,
                                  ListCategoriesUseCase listCategoriesUseCase) {
            this.createCategoryUseCase = createCategoryUseCase;
            this.listCategoriesUseCase = listCategoriesUseCase;
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

        @GetMapping
        @ResponseStatus(HttpStatus.OK)
        public List<Category> listCategory() {
            return listCategoriesUseCase.execute();
        }

}