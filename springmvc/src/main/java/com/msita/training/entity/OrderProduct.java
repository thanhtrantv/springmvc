package com.msita.training.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by thanhtran on 5/27/2018.
 */
@Entity
@Table(name="order-product", schema="training")
public class OrderProduct implements Serializable {
    @EmbeddedId
    private OrderProductKey key;

    @Column(name="quantity")
    private Integer quantity;

    @Column(name="price")
    private Integer price;

    @Column(name="date")
    private LocalDateTime date;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ido",referencedColumnName="ido", nullable=false, insertable=false, updatable=false)
    private Order order;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="idp",referencedColumnName="idp", nullable=false, insertable=false, updatable=false)
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderProductKey getKey() {
        return key;
    }

    public void setKey(OrderProductKey key) {
        this.key = key;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @PrePersist
    public void setCandidateProductId() {
        if (this.getKey().getIdo() == null) {
            this.getKey().setIdo(this.order.getIdo());
        }
        if (this.getKey().getIdp() == null) {
            this.getKey().setIdp(this.getProduct().getProductId());
        }
    }
}
