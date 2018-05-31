package com.msita.training.entity;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * Created by thanhtran on 5/27/2018.
 */
public class OrderProductKey implements Serializable {
    @Column(name="ido")
    private Integer ido;

    @Column(name="idp")
    private Integer idp;

    public Integer getIdo() {
        return ido;
    }

    public void setIdo(Integer ido) {
        this.ido = ido;
    }

    public Integer getIdp() {
        return idp;
    }

    public void setIdp(Integer idp) {
        this.idp = idp;
    }
}
