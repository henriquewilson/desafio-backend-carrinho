package br.com.geofusion.cart.repository;

import br.com.geofusion.cart.model.Product;
import br.com.geofusion.cart.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
