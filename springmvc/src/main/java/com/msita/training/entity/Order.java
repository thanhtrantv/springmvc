package com.msita.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by thanhtran on 5/24/2018.
 */
@Entity
@Table(name="order", schema="training")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="ido")
    private Integer ido;

    @Column(name="sum")
    private Integer sum;

    @Column(name="username")
    private String username;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="username",referencedColumnName="username", nullable=false, insertable=false, updatable=false)
    private User user;

    @JsonIgnoreProperties("order")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="order", fetch=FetchType.LAZY)
    private List<OrderProduct> lstOrderProduct;

    public List<OrderProduct> getLstOrderProduct() {
        return lstOrderProduct;
    }

    public void setLstOrderProduct(List<OrderProduct> lstOrderProduct) {
        this.lstOrderProduct = lstOrderProduct;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
