package com.bicimoto.app.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TblcomunicabajaPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Id;
    private String ndocbaja;

    public TblcomunicabajaPK() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNdocbaja() {
        return ndocbaja;
    }

    public void setNdocbaja(String ndocbaja) {
        this.ndocbaja = ndocbaja;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TblcomunicabajaPK)) {
            return false;
        }
        TblcomunicabajaPK castOther = (TblcomunicabajaPK)other;
        return
                this.Id.equals(castOther.Id)
                        && this.ndocbaja.equals(castOther.ndocbaja);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.Id.hashCode();
        hash = hash * prime + this.ndocbaja.hashCode();

        return hash;
    }
}
