/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Presupuesto;
import java.sql.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Beholder Systems
 */
public class ManejadorPresupuesto {

    private EntityManager em;
    private EntityManagerFactory emf;

    public ManejadorPresupuesto() {
        emf = Persistence
                .createEntityManagerFactory("ProyectoFinalPU");
        em = emf.createEntityManager();
    }

    public void guardarPresupuesto(BeanPresupuesto pr) {
        dao.Presupuesto p;
        p = new dao.Presupuesto();
        p.setCodPresupuesto(pr.getCodPresupuesto());
        p.setCodCliente(em.find(dao.Cliente.class, pr.getCodCliente()));
        p.setFecha(pr.getFecha());
        p.setCodFactura(em.find(dao.Factura.class, pr.getCodFactura()));
        p.setEstado(pr.getEstado());
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();

    }

    public void modificarPresupuesto(String codPresupuesto, BeanPresupuesto p) {
        em.getTransaction().begin();
        dao.Presupuesto presupuestoOld;
        presupuestoOld = em.find(dao.Presupuesto.class, "codPresupuesto");
        presupuestoOld.setCodCliente(em.find(dao.Cliente.class, p.getCodCliente()));
        presupuestoOld.setFecha(p.getFecha());
        presupuestoOld.setCodFactura(em.find(dao.Factura.class, p.getCodFactura()));
        presupuestoOld.setEstado(p.getEstado());
        em.getTransaction().commit();
    }

    void borrarPresupuesto(String codPresupuesto) {
        dao.Presupuesto p;
        p = em.find(dao.Presupuesto.class, "codPresupuesto");
        em.getTransaction().begin();
        em.remove(p);
        em.getTransaction().commit();
    }

    public Presupuesto buscarPresupuesto(String codPresupuesto) {
        dao.Presupuesto p;
        p = em.find(dao.Presupuesto.class, "codPresupuesto");
        return p;

    }
}