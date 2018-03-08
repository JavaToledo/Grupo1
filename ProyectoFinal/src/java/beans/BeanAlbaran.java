/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
import dao.Detalle;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.faces.event.AjaxBehaviorEvent;

import javax.inject.Named;

/**
 *
 * @author Beholder Systems
 */
@Named
public class BeanAlbaran implements Serializable {

    private String codAlbaran;
    private Integer codCliente;
    private Date Fecha;
    private Integer codFactura;
    private boolean bloqueo;
    private List<Detalle> listadoDetalle;
    private List<BeanAlbaran> listadoAlbaran;
    private List<Cliente> listadoCliente;
    private ManejadorAlbaran mn;

    public BeanAlbaran() {

    }

    public BeanAlbaran(String codAlbaran, Integer codCliente, Date Fecha, Integer codFactura, boolean bloqueo, List<BeanAlbaran> listadoAlbaran, List<Cliente> listadoCliente) {
        this.codAlbaran = codAlbaran;
        this.codCliente = codCliente;
        this.Fecha = Fecha;
        this.codFactura = codFactura;
        this.bloqueo = bloqueo;
        this.listadoAlbaran = listadoAlbaran;
        this.listadoCliente = listadoCliente;
          }

    public String getCodAlbaran() {
        return codAlbaran;
    }

    public void setCodAlbaran(String codAlbaran) {
        this.codAlbaran = codAlbaran;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Integer getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Integer codFactura) {
        this.codFactura = codFactura;
    }

    public boolean getBloqueo() {
        return bloqueo;
    }

    public void setBloqueo(boolean bloqueo) {
        this.bloqueo = bloqueo;
    }

    public List<BeanAlbaran> getListadoAlbaran() {
        return listadoAlbaran;
    }

    public void setListadoAlbaran(List<BeanAlbaran> listadoAlbaran) {
        this.listadoAlbaran = listadoAlbaran;
    }

    public List<Cliente> getListadoCliente() {
        return listadoCliente;
    }

    public void setListadoCliente(List<Cliente> listadoCliente) {
        this.listadoCliente = listadoCliente;
    }

    public ManejadorAlbaran getMn() {
        return mn;
    }

    public void setMn(ManejadorAlbaran mn) {
        this.mn = mn;
    }

    public List<Detalle> getListadoDetalle() {

        return listadoDetalle;
    }

    public void setListadoDetalle(List<Detalle> listadoDetalle) {
        this.listadoDetalle = listadoDetalle;
            }

    public void altaAlbaran(List listadoDetalle) {
        mn.altaAlbaran(this);
        mn.guardarDetalles(listadoDetalle);
    }

    public void modificarAlbaran(String codigoAlbaran) {
        mn.modificarAlbaran(codigoAlbaran,this);
    }
    
}
