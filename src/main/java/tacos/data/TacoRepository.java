package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.web.Taco;

public interface TacoRepository extends CrudRepository<Taco, Integer> {
}
