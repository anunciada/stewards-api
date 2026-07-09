package br.com.anunciada.stewards_api.application.ports.out;

import br.com.anunciada.stewards_api.domain.model.Category;
import java.util.List;

public interface CategoryPersistencePort {

    void save(Category category);

    List<Category> findAll();

}