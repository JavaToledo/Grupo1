/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Provincias;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Beholder Systems
 */
@Stateless
public class ProvinciasFacade extends AbstractFacade<Provincias> {

    @PersistenceContext(unitName = "Grupo1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProvinciasFacade() {
        super(Provincias.class);
    }
    
}