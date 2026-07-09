package br.com.anunciada.stewards_api.application.usecase.category;

import br.com.anunciada.stewards_api.domain.model.Category;
import java.util.List;

public interface ListCategoriesUseCase {

    List<Category> execute();

}