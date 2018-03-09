
package beans;

import dao.*;
import beans.BeanConceptos;
import java.beans.Beans;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author Alumno
 */
@Named

public class BeanConceptos implements Serializable{
    
    private List <dao.Conceptos> listadoconceptos;
    private int codConcepto;
    private String descripcion;
    private double importe;
    private int descuento;
    private int codIva;
    private boolean activado;
    
    private String buscar;

    public BeanConceptos() {
    }

    public BeanConceptos(List<dao.Conceptos> listadoconceptos, int codConcepto, String descripcion, double importe, int descuento, int codIva, boolean activado) {
        this.listadoconceptos = listadoconceptos;
        this.codConcepto = codConcepto;
        this.descripcion = descripcion;
        this.importe = importe;
        this.descuento = descuento;
        this.codIva = codIva;
        this.activado = activado;
    }

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public List<dao.Conceptos> getListadoconceptos() {
        return listadoconceptos;
    }

    public void setListadoconceptos(List<dao.Conceptos> listadoconceptos) {
        this.listadoconceptos = listadoconceptos;
    }

    public int getCodConcepto() {
        return codConcepto;
    }

    public void setCodConcepto(int codConcepto) {
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

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public int getCodIva() {
        return codIva;
    }

    public void setCodIva(int codIva) {
        this.codIva = codIva;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    
    public String AltaConcepto(){
        ManejadorConceptos mn= new ManejadorConceptos();
        int resultado = mn.guardar(Conceptos.class, this); 
        String mensaje = "Se guardó con éxito";
        return mensaje;
    }
     
    public String modificarConcepto (){
        ManejadorConceptos mn= new ManejadorConceptos();
        int resultado = mn.actualizarConceptos(Conceptos.class, this);
        String mensaje = "El concepto se modificó con éxito";
         
        return mensaje;
        
    }
    
    public List buscarConcepto (){
        ManejadorConceptos mn= new ManejadorConceptos();
        List resultado = mn.buscarConcepto("buscar");
        
        return resultado;
        
    }
    
    
}
