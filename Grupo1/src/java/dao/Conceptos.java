/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Beholder Systems
 */
@Entity
@Table(catalog = "annexfactura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Conceptos.findAll", query = "SELECT c FROM Conceptos c")
    , @NamedQuery(name = "Conceptos.findByCodConcepto", query = "SELECT c FROM Conceptos c WHERE c.codConcepto = :codConcepto")
    , @NamedQuery(name = "Conceptos.findByDescripcion", query = "SELECT c FROM Conceptos c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Conceptos.findByImporte", query = "SELECT c FROM Conceptos c WHERE c.importe = :importe")
    , @NamedQuery(name = "Conceptos.findByDescuento", query = "SELECT c FROM Conceptos c WHERE c.descuento = :descuento")
    , @NamedQuery(name = "Conceptos.findByActivado", query = "SELECT c FROM Conceptos c WHERE c.activado = :activado")})
public class Conceptos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer codConcepto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    private double importe;
    private Integer descuento;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date activado;
    @JoinColumn(name = "CodIva", referencedColumnName = "CodIva")
    @ManyToOne(optional = false)
    private Impuesto codIva;

    public Conceptos() {
    }

    public Conceptos(Integer codConcepto) {
        this.codConcepto = codConcepto;
    }

    public Conceptos(Integer codConcepto, String descripcion, double importe, Date activado) {
        this.codConcepto = codConcepto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.activado = activado;
    }

    public Integer getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(Integer codConcepto) {
        this.codConcepto = codConcepto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Integer getDescuento() {
        return descuento;
    }

    public void setDescuento(Integer descuento) {
        this.descuento = descuento;
    }

    public Date getActivado() {
        return activado;
    }

    public void setActivado(Date activado) {
        this.activado = activado;
    }

    public Impuesto getCodIva() {
        return codIva;
    }

    public void setCodIva(Impuesto codIva) {
        this.codIva = codIva;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConcepto != null ? codConcepto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Conceptos)) {
            return false;
        }
        Conceptos other = (Conceptos) object;
        if ((this.codConcepto == null && other.codConcepto != null) || (this.codConcepto != null && !this.codConcepto.equals(other.codConcepto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Conceptos[ codConcepto=" + codConcepto + " ]";
    }
    
}
