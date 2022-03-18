package br.com.geofusion.cart.controller;

import br.com.geofusion.cart.model.Item;
import br.com.geofusion.cart.model.Product;
import br.com.geofusion.cart.repository.ItemRepository;
import br.com.geofusion.cart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    ItemController() {
    }

    @PostMapping(path="/add-item")
    public @ResponseBody Item addNewItem (@RequestBody Item item) {
        return itemRepository.save(item);
    }

    @GetMapping(path="/all-items")
    public @ResponseBody Iterable<Item> getAllItems() {
        return itemRepository.findAll();
    }

}
