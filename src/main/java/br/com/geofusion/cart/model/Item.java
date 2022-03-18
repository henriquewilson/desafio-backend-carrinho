package br.com.geofusion.cart.model;


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

    @ManyToOne
    @JoinColumn(name = "product_code")
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
    public Item(Product product, BigDecimal unitPrice, int quantity) throws RuntimeException {
        if (product == null) {
            throw new RuntimeException("Product cannot be null");
        }
        if (unitPrice == null) {
            throw new RuntimeException("unitPrice cannot be null");
        }
        if (unitPrice.compareTo(BigDecimal.ZERO) <= 0 || quantity <= 0) {
            throw new RuntimeException("unitPrice and quantity must be greater than zero");
        }

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
    public int getQuantity() {
        return quantity;
    }

    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getAmount() {
        return unitPrice.multiply(BigDecimal.valueOf(quantity));
    }

    public Integer getId() {
        return id;
    }


}


