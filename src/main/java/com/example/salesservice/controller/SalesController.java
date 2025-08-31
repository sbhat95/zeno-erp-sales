package com.example.salesservice.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import com.example.salesservice.entity.*;
import com.example.salesservice.repository.*;

@RestController
@RequestMapping("/api")
public class SalesController {

    @Autowired private CustomerRepository customerRepo;
    @Autowired private ProductRepository productRepo;
    @Autowired private SaleRepository saleRepo;
    @Autowired private SaleItemRepository saleItemRepo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() { return customerRepo.findAll(); }

    @GetMapping("/products")
    public List<Product> getProducts() { return productRepo.findAll(); }

    @GetMapping("/sales")
    public List<Sale> getSales() { return saleRepo.findAll(); }
}
