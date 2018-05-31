package com.msita.training.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by thanhtran on 5/12/2018.
 */
@SuppressWarnings("serial")
@Entity
@Table(name="user", schema="training")
public class User implements Serializable {
    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="fullname")
    private String fullName;

    @JsonIgnoreProperties("user")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="user", fetch=FetchType.LAZY)
    private List<Order> listOrder;

    public String getFullname() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Order> getListOrder() {
        return listOrder;
    }

    public void setListOrder(List<Order> listOrder) {
        this.listOrder = listOrder;
    }
}
