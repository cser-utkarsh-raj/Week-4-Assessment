package com.capgemini.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.entity.Order;
import com.capgemini.model.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    // ✅ CREATE
    @PostMapping
    public Map<String, Object> createOrder(@RequestBody Order order) {
        return service.createOrder(order);
    }

    // ✅ GET BY ID
    @GetMapping("/{id}")
    public Object getOrder(@PathVariable Integer id) {
        return service.getOrderById(id);
    }

    // ✅ GET ALL
    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }

    // ✅ UPDATE
    @PutMapping("/{id}")
    public Map<String, String> updateOrder(@PathVariable Integer id,
                                           @RequestBody Order order) {
        return service.updateOrder(id, order);
    }

    // ✅ CANCEL (DELETE)
    @DeleteMapping("/{id}")
    public Map<String, String> cancelOrder(@PathVariable Integer id) {
        return service.cancelOrder(id);
    }
}