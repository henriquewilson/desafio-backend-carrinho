package br.com.geofusion.cart.controller;

import br.com.geofusion.cart.model.Item;
import br.com.geofusion.cart.model.ShoppingCart;
import br.com.geofusion.cart.repository.ShoppingCartRepository;
import br.com.geofusion.cart.service.ShoppingCartFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Collection;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    ShoppingCartController() {
    }

    @PostMapping(path = "/{clientId}/remove-item")
    public @ResponseBody
    ShoppingCart removeItem(@RequestBody Item item, @PathVariable String clientId) {
        try {
            ShoppingCart cart = shoppingCartRepository.findByClientId(clientId).get(0);
            cart.removeItem(item.getProduct());
            return this.shoppingCartRepository.save(cart);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "clientId  cannot be empty", e);
        }
    }

    @PostMapping(path = "/{clientId}/add-item")
    public @ResponseBody
    ShoppingCart addNewItem(@RequestBody Item item, @PathVariable String clientId) {
        try {
            ShoppingCart cart = shoppingCartRepository.findByClientId(clientId).get(0);
            cart.addItem(item.getProduct(), item.getUnitPrice(), item.getQuantity());
            return this.shoppingCartRepository.save(cart);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "clientId  cannot be empty", e);
        }
    }

    @GetMapping(path = "/{clientId}")
    public @ResponseBody
    ShoppingCart addNewShoppingCart(@PathVariable String clientId) {
        if (clientId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "clientId  cannot be empty");
        }
        return new ShoppingCartFactory(this.shoppingCartRepository).create(clientId);
    }

    @GetMapping(path = "/{clientId}/logout")
    public @ResponseBody
    boolean logoutShoppingCart(@PathVariable String clientId) {
        if (clientId == null) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "clientId  cannot be empty");
        }
        return new ShoppingCartFactory(this.shoppingCartRepository).invalidate(clientId);
    }


    @GetMapping(path = "/{clientId}/items")
    public @ResponseBody
    Collection<Item> allItemsByCart(@PathVariable String clientId) {
        try {
            ShoppingCart cart = shoppingCartRepository.findByClientId(clientId).get(0);
            return cart.getItems();
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "clientId  cannot be empty", e);
        }
    }
}
