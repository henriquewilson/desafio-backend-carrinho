package br.com.geofusion.cart.controller;

import br.com.geofusion.cart.model.Product;
import br.com.geofusion.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    ProductController() {
    }

    @PostMapping(path="/add-product")
    public @ResponseBody Product addNewProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping(path="/all-products")
    public @ResponseBody
    Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
