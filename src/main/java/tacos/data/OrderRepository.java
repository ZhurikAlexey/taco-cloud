package tacos.data;

import org.springframework.data.repository.CrudRepository;
import tacos.web.Order;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    /*List<Order> findByDeliveryZip(String deliveryZip);*/
}
