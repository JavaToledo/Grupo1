/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import java.util.Date;
import javax.inject.Named;

/**
 *
 * @author Alumno
 */
@Named
public class FacturaBean implements Serializable{
    
    String codFactura, observaciones;
    Integer codCliente;
    Date fecha;
    boolean emitida,pagada;
    //List <Factura> listadoFactura;
    //List <Detalle> listadoDetalle;
    //List <Cliente> listadoCliente;
    ManejadorFactura mf;
    
    /*
    METODOS
    +Set() y Get()
    +altaFactura()
    +List buscarFactor();
    +boolean emitirFactrua();
    +boolean pagarFactura();
    +List buscarDetalle();
    +boolean crearDetalle();
    */

    public String getCodFactura() {
        return codFactura;
    }

    public void setCodFactura(String codFactura) {
        this.codFactura = codFactura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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

    public boolean isEmitida() {
        return emitida;
    }

    public void setEmitida(boolean emitida) {
        this.emitida = emitida;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }
}
