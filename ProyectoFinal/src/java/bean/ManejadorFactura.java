/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Alumno
 */
public class ManejadorFactura {
    private EntityManager em;
    private EntityManagerFactory emf;
    
    /*
    METODOS
    +ManejadorFactura();
    +List listarFacturas();
    +FacturaBean buscarFactura(Cliente c);
    +int actualizarFactura(FacturaBean f);
    +int guardarFactura(FacturaBean f);
    +List listarDetalle();
    +Detalle buscarDetalle();
    +int guardarDetalle(Detalle d);
    +int actualizarDetalle(Detalle d);
    */
    
    public ManejadorFactura(){
        emf=Persistence.createEntityManagerFactory("proyectoFinal");
        em=emf.createEntityManager();
    }
    
    public List<FacturaBean> listarFacturas(){
        List<FacturaBean> listarFactura;
        try{
            listarFactura=em.createNamedQuery("Factura.findAll").getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return listarFactura;
    }
    
    public FacturaBean buscarFactura(Cliente c){
        FacturaBean f=new FacturaBean();
        Query q;
        if(f.getCodCliente() == c.getCodCliente()){
            q=em.createNamedQuery("Factura.findAll");
        }
        return null;
    }
    
    
}
