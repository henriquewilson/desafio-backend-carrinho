package br.com.geofusion.cart.service;

import br.com.geofusion.cart.model.Item;
import br.com.geofusion.cart.model.ShoppingCart;
import br.com.geofusion.cart.repository.ShoppingCartRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Iterator;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
@Service
public class ShoppingCartFactory {

    private ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartFactory(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     * <p>
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param clientId
     * @return ShoppingCart
     */
    public ShoppingCart create(String clientId) {
        Collection collection = this.shoppingCartRepository.findByClientId(clientId);
        if (collection.size() > 0) {
            return (ShoppingCart) collection.iterator().next();
        }
        ShoppingCart cart = new ShoppingCart(clientId);
        return this.shoppingCartRepository.save(cart);
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getAverageTicketAmount() {
        Iterator<ShoppingCart> iterator = this.shoppingCartRepository.findAll().iterator();
        BigDecimal average = BigDecimal.ZERO;
        int countCarts = 0;
        while (iterator.hasNext()) {
            average = average.add(iterator.next().getAmount());
            countCarts++;
        }
        average = average.divide(BigDecimal.valueOf(countCarts), 4, RoundingMode.HALF_UP);
        return scaleTwoDecimal(average);
    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param clientId
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidate(String clientId) {
        Collection collection = this.shoppingCartRepository.findByClientId(clientId);
        if (collection.size() > 0) {
            ShoppingCart cart = (ShoppingCart) collection.iterator().next();
            this.shoppingCartRepository.delete(cart);
            return true;
        }
        return false;
    }

    private BigDecimal scaleTwoDecimal(BigDecimal bigDecimal) {
        return bigDecimal.remainder(BigDecimal.ONE).compareTo(BigDecimal.valueOf(0.5)) < 0 ?
                bigDecimal.setScale(2, RoundingMode.HALF_DOWN) :
                bigDecimal.setScale(2, RoundingMode.HALF_UP);
    }
}
