package com.etiya.academy.controller;

import com.etiya.academy.entity.Product;
import com.etiya.academy.service.ProductService;
import com.etiya.academy.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Product> getAll() {

        return productService.getAll();
    }

    @PostMapping()
    public ResponseEntity<Product> add(@RequestBody Product product) {
        if (product != null) {
            productService.add(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable int id) {
        Product product = productService.getById(id);

        if (product != null) {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product product) {
        if (product != null) {
            productService.update(product);
            return new ResponseEntity<>(product, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable int id) {
        Product product = productService.getById(id);
        if (product != null) {
            productService.delete(id);
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
        return new ResponseEntity<>(product, HttpStatus.NOT_FOUND);

    }

}
