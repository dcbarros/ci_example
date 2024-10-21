package com.api.teste.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.teste.demo.model.Order;
import com.api.teste.demo.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Page<Order> getOrderByStatus(String status,Integer limit, Integer offset){
        Pageable pageable =  PageRequest.of(offset, limit);
        return orderRepository.findOrdersByStatus(status, pageable);
    }

    public void updateStatus(Integer order_id, String new_status){
        Order order = orderRepository.findById(order_id)
        .orElseThrow(() -> new RuntimeException("Order not found with id: " + order_id));
    
        if(!order.getStatus().equals(new_status)){
            order.setStatus(new_status);
            orderRepository.save(order);
        }
    }
}
