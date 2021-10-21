package com.kurdi.cqrsdomainevent.query.api.controllers;

import com.kurdi.cqrsdomainevent.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("api/query/products")
public class ProductsQueryController {

    @GetMapping("/")
    public ResponseEntity<Product> get()
    {
        return ResponseEntity.ok(new Product());
    }

}
