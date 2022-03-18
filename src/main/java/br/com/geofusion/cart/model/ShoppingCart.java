package br.com.geofusion.cart.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.*;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String clientId;

    @OneToMany(targetEntity = Item.class, mappedBy = "product", fetch = FetchType.EAGER)
    private List<Item> items;

    public ShoppingCart(Integer id, List<Item> items) {
        this.id = id;
        this.items = items;
    }

    protected ShoppingCart() {

    }

    public ShoppingCart(String clientId) {
        this.clientId = clientId;
    }

    /**
     * Permite a adição de um novo item no carrinho de compras.
     * <p>
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     * <p>
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param product
     * @param unitPrice
     * @param quantity
     */
    public void addItem(Product product, BigDecimal unitPrice, int quantity) {

    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param product
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removeItem(Product product) {
        return false;
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na
     * coleção, em que zero representa o primeiro item.
     *
     * @param itemIndex
     * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e false
     * caso o produto não exista no carrinho.
     */
    public boolean removeItem(int itemIndex) {
        if (getItems().size() >= itemIndex) {
            return false;
        }
        Iterator<Item> i = getItems().iterator();
        int j = 0;
        while(i.hasNext()) {
            Item x = i.next();
            if (j == itemIndex) {
                i.remove();
            }
        }
        return true;
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal
     */
    public BigDecimal getAmount() {
        BigDecimal amount = BigDecimal.valueOf(0);
        Iterator<Item> i = getItems().iterator();
        while(i.hasNext()) {
            Item x = i.next();
            amount.add(x.getAmount());
        }
        return amount;
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return items
     */
    public Collection<Item> getItems() {
        if (this.items == null) {
            return Collections.emptyList();
        }
        return this.items;
    }


}