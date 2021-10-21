package com.kurdi.cqrsdomainevent.command.api.controllers;

import com.kurdi.cqrsdomainevent.command.api.commands.CreateProductCommand;
import com.kurdi.cqrsdomainevent.entities.Product;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/products")
public class ProductsCommandController {

    @Autowired
    CommandGateway commandGateway;
    @PostMapping("/")
    public ResponseEntity<Product> post(@RequestBody Product product)
    {
        CreateProductCommand createProductCommand = new CreateProductCommand();
        BeanUtils.copyProperties(product, createProductCommand);

        Product productResult =  commandGateway.sendAndWait(createProductCommand);
        return ResponseEntity.ok(productResult);
    }

}
