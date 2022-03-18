package br.com.geofusion.cart.service;

import br.com.geofusion.cart.model.ShoppingCart;
import br.com.geofusion.cart.repository.ShoppingCartRepository;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class ShoppingCartFactory {

    private ShoppingCartRepository shoppingCartRepository;

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
        return null;
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
}
