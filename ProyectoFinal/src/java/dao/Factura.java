/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Beholder Systems
 */
@Entity
@Table(catalog = "annexfactura", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByPagada", query = "SELECT f FROM Factura f WHERE f.pagada = :pagada")
    , @NamedQuery(name = "Factura.findByCodFactura", query = "SELECT f FROM Factura f WHERE f.codFactura = :codFactura")
    , @NamedQuery(name = "Factura.findByEmitida", query = "SELECT f FROM Factura f WHERE f.emitida = :emitida")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    private boolean pagada;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    private String codFactura;
    private Boolean emitida;
    @OneToMany(mappedBy = "codFactura")
    private List<Presupuesto> presupuestoList;
    @JoinColumn(name = "CodCliente", referencedColumnName = "CodCliente")
    @ManyToOne(optional = false)
    private Cliente codCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCodFactura")
    private List<Detalle> detalleList;

    public Factura() {
    }

    public Factura(String codFactura) {
        this.codFactura = codFactura;
    }

    public Factura(String codFactura, Date fecha, String observaciones, boolean pagada) {
        this.codFactura = codFactura;
        this.fecha = fecha;
        this.observaciones = observaciones;
        this.pagada = pagada;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public Boolean getEmitida() {
        return emitida;
    }

    public void setEmitida(Boolean emitida) {
        this.emitida = emitida;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    public Cliente getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Cliente codCliente) {
        this.codCliente = codCliente;
    }

    @XmlTransient
    public List<Detalle> getDetalleList() {
        return detalleList;
    }

    public void setDetalleList(List<Detalle> detalleList) {
        this.detalleList = detalleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFactura != null ? codFactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codFactura == null && other.codFactura != null) || (this.codFactura != null && !this.codFactura.equals(other.codFactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dao.Factura[ codFactura=" + codFactura + " ]";
    }
    
}
