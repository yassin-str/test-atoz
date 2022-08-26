package lu.atozdigital.api.services;

import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.models.OrderT;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderT save(OrderT article);
    Optional<OrderT> getOrderByID(Long id);
    List<OrderT> getAll();
}
