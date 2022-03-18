package br.com.geofusion.cart.controller;

import br.com.geofusion.cart.model.ShoppingCart;
import br.com.geofusion.cart.repository.ShoppingCartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    ShoppingCartController() {
    }

    @PostMapping(path="/add-cart")
    public @ResponseBody ShoppingCart addNewShoppingCart(@RequestBody ShoppingCart product) {
        return shoppingCartRepository.save(product);
    }

    @GetMapping(path="/all-carts")
    public @ResponseBody
    Iterable<ShoppingCart> getAllShoppingCarts() {
        return shoppingCartRepository.findAll();
    }
}
