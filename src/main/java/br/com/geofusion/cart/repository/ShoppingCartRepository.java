package br.com.geofusion.cart.repository;

import br.com.geofusion.cart.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Integer> {

    List<ShoppingCart> findByClientId(String s);
}
