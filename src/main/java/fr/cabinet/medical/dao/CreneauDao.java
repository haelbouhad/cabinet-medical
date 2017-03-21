/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Medecin;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ousmane
 */
@Stateless
public class CreneauDao implements ICreneauDao {
    
    @PersistenceContext
    protected EntityManager em ;
    
    @Override
    public List<Creneau> getCrenauxLibres(Medecin medecin)
    {
        return em.createQuery("SELECT c FROM Creneau c WHERE c.medecin.id = :medecin_id AND c.rdv IS NULL").setParameter("medecin_id", medecin.getId()).getResultList() ;
    }
    
    @Override
    public List<Creneau> getCrenauxLibres()
    {
        em.flush();
        return this.em.createQuery("SELECT c FROM Creneau c WHERE c.rdv is null").getResultList() ;
    }

    @Override
    public Creneau getOne(Long id) {
        return em.find(Creneau.class, id) ;
    }
    
    @Override
     public Long create(Creneau c){
        em.persist(c);
        return c.getId() ;
    }
    
    
    @Override
    public void update(Creneau c)
    {
        em.merge(c) ;
    }
    
    @Override
    public boolean exists(Creneau c){
        return em.contains(c) ;
    }
    
    @Override
    public void delete(Creneau c)
    {
        em.remove(c);
    }
    
}
