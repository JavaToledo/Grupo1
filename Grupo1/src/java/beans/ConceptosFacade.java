/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import dao.Conceptos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Beholder Systems
 */
@Stateless
public class ConceptosFacade extends AbstractFacade<Conceptos> {

    @PersistenceContext(unitName = "Grupo1PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConceptosFacade() {
        super(Conceptos.class);
    }
    
}
