/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
import dao.Detalle;
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

    public List listadoAlbaranes(Albaran a) {
        List listadoAlbaranes = em.createNamedQuery("Albaran.findAll").getResultList();
        return listadoAlbaranes;
    }

    public Albaran buscarAlbaran(Cliente c) {
        
            return null;
    }

    public int guardar(Albaran a) {

        em.getTransaction().begin();
        em.persist(a);
        em.getTransaction().commit();
        return 0;
    }

    public int actualizarAlbaran(Albaran a) {
        em.getTransaction().begin();
        dao.Albaran albaranOld;
        albaranOld = em.find( dao.Albaran.class, a.getCodAlbaran());
        albaranOld.setFecha(a.getFecha());
        albaranOld.setDetalleList(a.getListadoDetalle());
        em.getTransaction().commit();
        return 0;
    }
     

    public List listarDetalle(Detalle d) {
        List listadoDetalle = em.createNamedQuery("Detalle.findAll").getResultList();
        return listadoDetalle;
    }
}
