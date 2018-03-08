/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Cliente;
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

    public int altaAlbaran(BeanAlbaran a) {
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
        return 0;
    }

    public int modificarAlbaran(BeanAlbaran a) {
        em.getTransaction().begin();
        dao.Albaran albaranOld;
        albaranOld = em.find(dao.Albaran.class, a.getCodAlbaran());
        albaranOld.setFecha(a.getFecha());
        albaranOld.setDetalleList(a.getListadoDetalle());
        em.getTransaction().commit();
        return 0;
    }

    public List listadoAlbaranes() {
        List listadoAlbaranes = em.createNamedQuery("Albaran.findAll").getResultList();
        return listadoAlbaranes;
    }

    public List buscarAlbaran(String codAlbaran) {
        List listadoAlbaranes = em.createNamedQuery("Albaran.findByCodAlbaran").getResultList();
        return listadoAlbaranes;
    }

    public boolean bloquearAlbaran(BeanAlbaran a) {
        em.find(dao.Albaran.class, a.getCodAlbaran()).setBloqueado(Boolean.TRUE);
        return true;
    }

    public List listarDetalle(Detalle d) {
        List listadoDetalle = em.createNamedQuery("Detalle.findAll").getResultList();
        return listadoDetalle;
    }

    public int guardarDetalle(Detalle d) {
        em.getTransaction().begin();
        em.persist(d);
        em.getTransaction().commit();
        return 0;
    }

    public int guardarDetalles(List listadoDetalles) {
        for (Object detalle : listadoDetalles) {
            guardarDetalle((Detalle) detalle);
        }
        return 0;
    }
}
