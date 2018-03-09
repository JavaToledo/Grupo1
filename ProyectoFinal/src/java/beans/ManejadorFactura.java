/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private Connection conexion;
    
    /*
    METODOS
    +ManejadorFactura(); DONE
    +List listarFacturas(); DONE
    +FacturaBean buscarFactura(Cliente c); DONE
    +int actualizarFactura(FacturaBean f); DONE
    +int guardarFactura(FacturaBean f); DONE
    +List listarDetalle(); DONE
    +int guardarDetalle(Detalle d); 
    +int actualizarDetalle(Detalle d); 
    +list listarConceptos();
    +
    */
    
    /*
    Class.forName("com.mysql.jdbc.Driver");
    String url="jdbc:mysql://localhost:3306/annexfactura?zeroDateTimeBehavior=convertToNull";
    String user="root";
    String password="aula05";
    */
    public ManejadorFactura(){
        emf=Persistence.createEntityManagerFactory("proyectoFinal");
        em=emf.createEntityManager();
        
    }
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/annexfactura?zeroDateTimeBehavior=convertToNull";
            String user="root";
            String password="aula05";
            conexion=DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return conexion;
    }
    
    public List listarFacturas(){
        List listarFactura;
        try{
            listarFactura=em.createNamedQuery("Factura.findAll").getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return listarFactura;
    }
    
    public List<FacturaBean> buscarFactura(Cliente c){
        FacturaBean fb=new FacturaBean();
        List<FacturaBean> listarFactura;
        Query q;
        if(fb.getCodCliente() == c.getCodCliente()){
            q=em.createNamedQuery("Factura.findByNombreLike");
            q.setParameter(1,c);  
            listarFactura=q.getResultList();
        }else{
            listarFactura=em.createNamedQuery("Factura.findAll").getResultList();
        }
        return listarFactura;
    }
    
    public int actualizarFactura(FacturaBean fb){
        em.getTransaction().begin();
        FacturaBean facturaOld=em.find(FacturaBean.class, fb.getCodFactura());
        facturaOld.setCodCliente(fb.getCodCliente());
        facturaOld.setObservaciones(fb.getObservaciones());
        facturaOld.setFecha(fb.getFecha());
        facturaOld.setEmitida(fb.isEmitida());
        facturaOld.setPagada(fb.isPagada());
        return 1;
        //1=SE HA ACTUALIZADO
    }
    
    public int guardarFactura(FacturaBean fb){
        em.getTransaction().begin();
        em.persist(fb);
        em.getTransaction().commit();
        return 1;
        //1=SE HA GUARDADO CORRECTAMENTE
    }
    
    public List listarDetalle(){
        List listarDetalle;
        try{
            listarDetalle=em.createNamedQuery("Detalle.findAll").getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        return listarDetalle;
    }
    
    /*
        +int guardarDetalle(Detalle d); 
        public int guardarFactura(FacturaBean fb){
        em.getTransaction().begin();
        em.persist(fb);
        em.getTransaction().commit();
        return 1;
        //1=SE HA GUARDADO CORRECTAMENTE
    }*/
    
    public int guardarDetalle(){
        return 0;
    }
    
    
}
