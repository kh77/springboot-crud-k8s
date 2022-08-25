package com.sm.service;

import com.sm.entity.Order;
import com.sm.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public Order create(Order order) {
        return repository.save(order);
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order getDetailsById(Long id) {
        return repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id : " + id));
    }
}
