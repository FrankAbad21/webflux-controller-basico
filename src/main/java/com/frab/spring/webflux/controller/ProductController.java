package com.frab.spring.webflux.controller;

import com.frab.spring.webflux.entity.Product;
import com.frab.spring.webflux.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/product")
@Slf4j
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Flux<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Product> getById(@PathVariable("id") int id) {
        return productService.getById(id);
    }

    @PostMapping
    public Mono<Product> save(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{id}")
    public Mono<Product> update(@PathVariable("id") int id, @RequestBody Product product) {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") int id) {
        return productService.delete(id);
    }

}
