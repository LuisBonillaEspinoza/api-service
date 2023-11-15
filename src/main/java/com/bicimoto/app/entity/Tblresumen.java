package com.bicimoto.app.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tblresumen")
public class Tblresumen implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private TblresumenPK id;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private String ticket;

    private String codError;

    private String mensajeError;

    private String mensajeRespuesta;

    private String archXml;

    private String nomArchXml;

    private String est;

    private String rucEmpresa;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCreacion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModi;

    private String userCreacion;

    private String userModi;

    public TblresumenPK getId() {
        return id;
    }

    public void setId(TblresumenPK id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }

    public String getArchXml() {
        return archXml;
    }

    public void setArchXml(String archXml) {
        this.archXml = archXml;
    }

    public String getNomArchXml() {
        return nomArchXml;
    }

    public void setNomArchXml(String nomArchXml) {
        this.nomArchXml = nomArchXml;
    }

    public String getEst() {
        return est;
    }

    public void setEst(String est) {
        this.est = est;
    }

    public String getRucEmpresa() {
        return rucEmpresa;
    }

    public void setRucEmpresa(String rucEmpresa) {
        this.rucEmpresa = rucEmpresa;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Date getFecModi() {
        return fecModi;
    }

    public void setFecModi(Date fecModi) {
        this.fecModi = fecModi;
    }

    public String getUserCreacion() {
        return userCreacion;
    }

    public void setUserCreacion(String userCreacion) {
        this.userCreacion = userCreacion;
    }

    public String getUserModi() {
        return userModi;
    }

    public void setUserModi(String userModi) {
        this.userModi = userModi;
    }
}
