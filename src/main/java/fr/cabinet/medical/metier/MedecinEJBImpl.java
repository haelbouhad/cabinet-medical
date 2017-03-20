/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Medecin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hassan
 */
@Stateless(name = "MED")
public class MedecinEJBImpl implements IMedecinLocal, IMedecinRemote{

    @PersistenceContext(unitName = "UP")
    private EntityManager em;
    
    @Override
    public Long addMedecin(Medecin m) {
        em.persist(m);
        return m.getCode();
    }

    @Override
    public List<Medecin> getAllMedecins() {
        Query q = em.createQuery("select m from Medecin m");
        return q.getResultList(); 
    }

    @Override
    public Medecin getMedecin(Long code) {
        Medecin m = em.find(Medecin.class, code);
        if(m == null)
            throw new RuntimeException("Médecin introuvable");
        return m;
    }

    @Override
    public void supprimerMedecin(Long code) {
        Medecin m = em.find(Medecin.class, code);
        em.remove(m);
    }
    
    
    
}
