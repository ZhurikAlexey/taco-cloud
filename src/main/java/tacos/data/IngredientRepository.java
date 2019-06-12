package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.web.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
/*    Iterable<Ingredient> findAll();
    Ingredient findOne(String id);
    Ingredient save(Ingredient ingredient);*/
}
