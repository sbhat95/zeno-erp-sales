package com.example.salesservice.service;

import com.example.salesservice.dto.CreateOrderRequest;
import com.example.salesservice.entity.Customer;
import com.example.salesservice.entity.SalesOrder;
import com.example.salesservice.entity.SalesOrderItem;
import com.example.salesservice.repository.CustomerRepository;
import com.example.salesservice.repository.SalesOrderItemRepository;
import com.example.salesservice.repository.SalesOrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrderService {

    private final CustomerRepository customerRepository;
    private final SalesOrderRepository salesOrderRepository;
    private final SalesOrderItemRepository salesOrderItemRepository;

    public OrderService(CustomerRepository customerRepository,
                        SalesOrderRepository salesOrderRepository,
                        SalesOrderItemRepository salesOrderItemRepository) {
        this.customerRepository = customerRepository;
        this.salesOrderRepository = salesOrderRepository;
        this.salesOrderItemRepository = salesOrderItemRepository;
    }

    @Transactional
    public SalesOrder createOrder(CreateOrderRequest request) {
        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

        SalesOrder order = SalesOrder.builder()
                .customer(customer)
                .orderDate(LocalDate.now())
                .status("PENDING")
                .build();

        order = salesOrderRepository.save(order);

        for (var itemReq : request.getItems()) {
            SalesOrderItem item = SalesOrderItem.builder()
                    .salesOrder(order)
                    .productId(itemReq.getProductId())
                    .quantity(itemReq.getQuantity())
                    .unitPrice(itemReq.getUnitPrice())
                    .build();
            salesOrderItemRepository.save(item);
            order.getItems().add(item);
        }
        return order;
    }
}
