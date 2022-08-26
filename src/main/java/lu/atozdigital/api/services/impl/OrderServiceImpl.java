package lu.atozdigital.api.services.impl;

import lombok.AllArgsConstructor;
import lu.atozdigital.api.models.OrderT;
import lu.atozdigital.api.repositories.OrderRepository;
import lu.atozdigital.api.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public OrderT save(OrderT order) {
        return orderRepository.save(order);
    }

    @Override
    public Optional<OrderT> getOrderByID(Long id) {
        return orderRepository.findById(id) ;
    }

    @Override
    public List<OrderT> getAll() {
        return (List<OrderT>) orderRepository.findAll();
    }
}
