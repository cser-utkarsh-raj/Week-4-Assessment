package com.capgemini.model.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Order;
import com.capgemini.model.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    
    public Map<String, Object> createOrder(Order order) {

        if (order.getQuantity() <= 0) {
            return Map.of("message", "Quantity must be greater than 0");
        }

        order.setStatus("PLACED");

        Order saved = orderRepository.save(order);

        return Map.of(
                "message", "Order created successfully",
                "orderId", saved.getOrderId()
        );
    }


    public Object getOrderById(Integer id) {

        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Order not found");
        }

        return optional.get();
    }

   
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Map<String, String> updateOrder(Integer id, Order updatedOrder) {

        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Order not found");
        }

        Order existing = optional.get();

        if ("CANCELLED".equals(existing.getStatus())) {
            return Map.of("message", "Cannot update cancelled order");
        }

        if (updatedOrder.getQuantity() <= 0) {
            return Map.of("message", "Quantity must be greater than 0");
        }

        existing.setCustomerName(updatedOrder.getCustomerName());
        existing.setFoodItem(updatedOrder.getFoodItem());
        existing.setQuantity(updatedOrder.getQuantity());

        orderRepository.save(existing);

        return Map.of("message", "Order updated successfully");
    }


    public Map<String, String> cancelOrder(Integer id) {

        Optional<Order> optional = orderRepository.findById(id);

        if (optional.isEmpty()) {
            return Map.of("message", "Order not found");
        }

        Order existing = optional.get();

        existing.setStatus("CANCELLED");

        orderRepository.save(existing);

        return Map.of("message", "Order cancelled successfully");
    }
}