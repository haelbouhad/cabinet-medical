/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

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
public class MedecinDao implements IMedecinDao{
    
    @PersistenceContext(name = "UP")
    protected EntityManager em ;

    @Override
   public Medecin getOne(Long id) {
        return em.find(Medecin.class, id) ;
    }
    
    @Override
     public Long create(Medecin a){
        em.persist(a);
        return a.getId() ;
    }
    
    
    @Override
    public void update(Medecin a)
    {
        em.merge(a) ;
    }
    
    @Override
    public boolean exists(Medecin a){
        return em.contains(a) ;
    }
    
    @Override
    public void delete(Long id)
    {
        Medecin m = em.getReference(Medecin.class, id) ;
        em.remove(m);
    }

    @Override
    public List<Medecin> getAll() {
        return em.createQuery("SELECT m FROM Medecin m").getResultList() ;
    }
}
