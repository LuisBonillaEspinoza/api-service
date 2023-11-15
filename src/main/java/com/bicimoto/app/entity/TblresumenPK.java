package com.bicimoto.app.entity;

import java.io.Serializable;

public class TblresumenPK implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Id;
    private String ndocbaja;

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
        if (!(other instanceof TblresumenPK)) {
            return false;
        }
        TblresumenPK castOther = (TblresumenPK)other;
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
