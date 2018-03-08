/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Albaran;
import dao.Detalle;
import dao.Factura;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Beholder Systems
 */
class ManejadorAlbaran {
    
    private EntityManager em;
    private EntityManagerFactory emf;
    
    public ManejadorAlbaran() {
        emf = Persistence
                .createEntityManagerFactory("ProyectoFinalPU");
        em = emf.createEntityManager();
    }
    
    public void altaAlbaran(BeanAlbaran a) {
        dao.Albaran al;
        al = new dao.Albaran();
        al.setCodAlbaran(a.getCodAlbaran());
        al.setCodCliente(em.find(dao.Cliente.class, a.getCodCliente()));
        al.setCodFactura(a.getCodFactura());
        al.setFecha(a.getFecha());
        al.setBloqueado(a.getBloqueo());
        em.getTransaction().begin();
        em.persist(al);
        em.getTransaction().commit();
           }

 public void modificarAlbaran(String codAlbaran, BeanAlbaran a) {
        em.getTransaction().begin();
        dao.Albaran albaranOld;
        albaranOld = em.find(dao.Albaran.class, "codAlbaran");
        albaranOld.setCodCliente(em.find(dao.Cliente.class, a.getCodCliente()));
        albaranOld.setFecha(a.getFecha());
        albaranOld.setCodFactura(a.getCodFactura());
        albaranOld.setDetalleList(a.getListadoDetalle());
        albaranOld.setBloqueado(Boolean.FALSE);
        em.getTransaction().commit();

    }
   public List listadoAlbaranes() {
        List listadoAlbaranes = em.createNamedQuery("Albaran.findAll").getResultList();
        return listadoAlbaranes;
    }

    public void guardarDetalle(Detalle d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        
    }

    public void guardarDetalles(List listadoDetalles) {
        for (Object detalle : listadoDetalles) {
            guardarDetalle((Detalle) detalle);
        }
      
    }
   

    public boolean bloquearAlbaran(BeanAlbaran a) {
        em.find(dao.Albaran.class, a.getCodAlbaran()).setBloqueado(Boolean.TRUE);
        return true;
    }
  
}
