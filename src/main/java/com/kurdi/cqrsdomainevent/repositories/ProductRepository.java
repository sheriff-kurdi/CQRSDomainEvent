package com.kurdi.cqrsdomainevent.repositories;

import com.kurdi.cqrsdomainevent.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
