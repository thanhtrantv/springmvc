package com.msita.training.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by thanhtran on 5/24/2018.
 */
@Entity
@Table(name="order", schema="training")
public class Order implements Serializable {
    @Id
    @Column(name="ido")
    private Integer ido;

    @Column(name="sum")
    private Integer sum;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="username",referencedColumnName="username", nullable=false, insertable=false, updatable=false)
    private User user;

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
