package com.api.teste.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.teste.demo.model.Order;
import com.api.teste.demo.service.OrderService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @GetMapping()
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/search")
    public Page<Order> getOrdersByStatus(
        @RequestParam(name = "status", required = false, defaultValue = "pending") String status, 
        @RequestParam(name = "limit", defaultValue = "10") Integer limit,
        @RequestParam(name = "page", defaultValue = "0") Integer offset) {
        return orderService.getOrderByStatus(status, limit, offset);
    }
    
    @PatchMapping("/{id}/status")
    public void changeOrderStatus(@RequestParam(name = "status") String status, @PathVariable Integer id){
        orderService.updateStatus(id, status);
    }
}
