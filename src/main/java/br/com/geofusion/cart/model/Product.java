package br.com.geofusion.cart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long code;

    private String description;

    /**
     * Construtor da classe Produto.
     *
     * @param code
     * @param description
     */
    public Product(Long code, String description) {
        this.code = code;
        this.description = description;
    }

    protected Product() {

    }

    /**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCode() {
        return this.code;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescription() {
        return this.description;
    }


}