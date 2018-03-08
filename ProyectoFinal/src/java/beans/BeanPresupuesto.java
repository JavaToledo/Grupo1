/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
import dao.Factura;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author Beholder Systems
 */
@Named
public class BeanPresupuesto implements Serializable{
    private String codPresupuesto;
    private Integer codCliente;
    private Date fecha;
    private Integer codFactura;
    private String estado;
    private List <Factura> listadoFacturas;
    private List <Cliente> listadoClientes;
    private ManejadorPresupuesto mn;

    public BeanPresupuesto() {
    }

    public BeanPresupuesto(String codPresupuesto, Integer codCliente, Date fecha, Integer codFactura, String estado, List<Factura> listadoFacturas, List<Cliente> listadoClientes) {
        this.codPresupuesto = codPresupuesto;
        this.codCliente = codCliente;
        this.fecha = fecha;
        this.codFactura = codFactura;
        this.estado = estado;
        this.listadoFacturas = listadoFacturas;
        this.listadoClientes = listadoClientes;
    }

    public String getCodPresupuesto() {
        return codPresupuesto;
    }

    public void setCodPresupuesto(String codPresupuesto) {
        this.codPresupuesto = codPresupuesto;
    }

    public Integer getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Integer codCliente) {
        this.codCliente = codCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(Integer codFactura) {
        this.codFactura = codFactura;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List <Factura> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List <Factura> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }

    public List <Cliente> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(List <Cliente> listadoClientes) {
        this.listadoClientes = listadoClientes;
    }
   public void altaPresupuesto() {
        mn.altaPresupuesto(this);
        
    }

    public void modificarPresupuesto(String codAlbaran) {
        mn.modificarPresupuesto(codAlbaran,this);
    } 
    
}
