package br.com.geofusion.cart.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Product product;
    private BigDecimal unitPrice;
    private Integer quantity;

    /**
     * Construtor da classe Item.
     *
     * @param product
     * @param unitPrice
     * @param quantity
     */
    public Item(Product product, BigDecimal unitPrice, int quantity) {
        this.product = product;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
    }

    protected Item() {

    }

    /**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Product getProduct() {
        return this.product;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    @Transient
    public BigDecimal getAmount() {
        return BigDecimal.valueOf(0);
//        if (unitPrice != null) {
//        }
//        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public Integer getId() {
        return id;
    }


}


