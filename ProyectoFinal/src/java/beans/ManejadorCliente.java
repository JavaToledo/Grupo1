/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
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
public class ManejadorCliente {
    
    
     private EntityManager em;
    private EntityManagerFactory emf;

    public ManejadorCliente() {
        emf = Persistence
                .createEntityManagerFactory("ProyectoFinalPU");
        em = emf.createEntityManager();
    }
    
   public List<ClienteBean> listarClientes(){
        List listado=em.createNamedQuery("Cliente.findAll", Cliente.class)
                .getResultList();
       return listado;
    }
    
    public List<ClienteBean> buscarCliente(String nombre) {
        ClienteBean c = new ClienteBean();
        List<ClienteBean> listaClientes;
        Query q;
        if (c.getNombre().equals(nombre)) {
            q = em.createNamedQuery("Cliente.findByNombre");
            q.setParameter(1, nombre);
            listaClientes = q.getResultList();
            
        } else {
            listaClientes = em.createNamedQuery("Cliente.findAll").getResultList();
        }
        return listaClientes;
        
    }
    
    
    
    
    
    
    
    
    public int actualizarCliente(Cliente c){
         
         ClienteBean clienteOld = em.find(ClienteBean.class, c.getCodCliente());
         clienteOld.setNombre(c.getNombre());
         clienteOld.setApellido1(c.getApellido1());
         clienteOld.setApellido2(c.getApellido2());
         clienteOld.setDni(c.getDni()); 
         clienteOld.setDireccion(c.getDireccion());
         clienteOld.setMunicipio(c.getMunicipio());
         //clienteOld.setCodprovincia(c.getCodProvincia());
         clienteOld.setCodigopostal(c.getCodigoPostal());
         clienteOld.setEmail(c.getEmail());
         clienteOld.setTelefono(c.getTelefono());
         
         em.getTransaction().begin();
         em.persist(clienteOld);
         em.getTransaction().commit();
         return 0;
         
         
    }
    
    
    
    
    
    
    
    
    public int guardarCliente(Cliente c){
        try {
        em.getTransaction().begin();
        
        em.getTransaction().commit();
        } catch (Exception e ) {
            System.out.println("Error guardando al cliente");
            return -1;
        }
        return 0;
        
    } 
 
    
 public List<ProvinciasBean> listarProvincias(){
        List listado=em.createNamedQuery("Provincias.findAll", dao.Provincias.class)
                .getResultList();
       return listado;
    }
    
    
    
}
