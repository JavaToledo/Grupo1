
package beans;

import dao.Conceptos;
import dao.Impuesto;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManejadorConceptos {
    static EntityManager em;
    static EntityManagerFactory emf;
    
    public ManejadorConceptos() {
        emf = Persistence
                .createEntityManagerFactory("ProyectoFinalPU");
        em = emf.createEntityManager();
    }
    public List listar(Conceptos c){
       String query;
       List listado=em.createNamedQuery("Conceptos.findAll").getResultList();
       return listado;
    }
    int guardar(Class<dao.Conceptos> aClass, BeanConceptos aThis) {
        
        dao.Conceptos co= new dao.Conceptos();
        co.setActivado(aThis.isActivado());
        co.setCodConcepto(aThis.getCodConcepto());
        co.setCodIva(em.find(Impuesto.class, aThis.getCodIva()));
        co.setDescripcion(aThis.getDescripcion());
        co.setDescuento(aThis.getDescuento());
        co.setImporte(aThis.getImporte());
        em.getTransaction().begin();
        em.persist(co);
        em.getTransaction().commit();
        
        return -1;
    }
     

   int actualizarConceptos(Class<dao.Conceptos> aClass, BeanConceptos aThis) {
        em.getTransaction().begin();
        dao.Conceptos conceptosOld;
        conceptosOld = em.find(dao.Conceptos.class, aThis.getCodConcepto());
        conceptosOld.setActivado(aThis.isActivado());
        conceptosOld.setCodIva(em.find(Impuesto.class, aThis.getCodIva()));
        conceptosOld.setDescripcion(aThis.getDescripcion());
        conceptosOld.setDescuento(aThis.getDescuento());
        conceptosOld.setImporte(aThis.getImporte());
        
        em.getTransaction().commit();
        return 0;
    }
   public List buscarConcepto (String buscar){
        List listado=em.createNamedQuery("Conceptos.findByCodConcepto").getResultList();
       return listado;
       
   }



    

    
  
}
