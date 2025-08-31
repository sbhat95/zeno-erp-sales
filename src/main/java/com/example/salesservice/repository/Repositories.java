package com.example.salesservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.salesservice.entity.*;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
public interface ProductRepository extends JpaRepository<Product, Long> {}
public interface SaleRepository extends JpaRepository<Sale, Long> {}
public interface SaleItemRepository extends JpaRepository<SaleItem, Long> {}
