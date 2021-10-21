package com.kurdi.cqrsdomainevent.command.api.events;

import com.kurdi.cqrsdomainevent.entities.Product;
import com.kurdi.cqrsdomainevent.repositories.ProductRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {

    @Autowired
    ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        Product product = new Product();
        BeanUtils.copyProperties(event,product);
        productRepository.save(product);

    }
}
