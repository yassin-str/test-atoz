package lu.atozdigital.api.repositories;

import lu.atozdigital.api.models.Article;
import lu.atozdigital.api.models.OrderT;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends CrudRepository<OrderT,Long> {
}
