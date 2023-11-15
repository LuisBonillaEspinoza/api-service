package com.bicimoto.app.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;
@Embeddable
public class TblempresaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String ruc;

    public TblempresaPK() {
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TblempresaPK)) {
            return false;
        }
        TblempresaPK castOther = (TblempresaPK)other;
        return
                this.ruc.equals(castOther.ruc);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.ruc.hashCode();

        return hash;
    }
}
