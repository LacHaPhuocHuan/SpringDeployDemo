package com.example.deploydemo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/demo")
public class DemoRest {
    private final ProductJpa productJpa;
    @GetMapping("")
    public ResponseEntity<?> getAll(){
        List<Product> products=productJpa.findAll();
        return ResponseEntity.ok(products);
    }
    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ProductDto product){
        var productSave=Product.builder().price(product.price)
                .name(product.name)
                .description(product.description)
                .build();
        productJpa.save(productSave);
        return ResponseEntity.ok("\"message\" : \""+ "Create Successfully"+"\"" );
    }

}
