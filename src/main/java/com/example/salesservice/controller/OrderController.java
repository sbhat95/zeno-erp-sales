package com.example.salesservice.controller;

import com.example.salesservice.dto.CreateOrderRequest;
import com.example.salesservice.entity.SalesOrder;
import com.example.salesservice.repository.SalesOrderRepository;
import com.example.salesservice.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;
    private final SalesOrderRepository salesOrderRepository;

    public OrderController(OrderService orderService, SalesOrderRepository salesOrderRepository) {
        this.orderService = orderService;
        this.salesOrderRepository = salesOrderRepository;
    }

    @PostMapping
    public SalesOrder create(@Valid @RequestBody CreateOrderRequest request) {
        return orderService.createOrder(request);
    }

    @GetMapping
    public List<SalesOrder> all() {
        return salesOrderRepository.findAll();
    }
}
