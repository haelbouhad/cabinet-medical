/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Rdv;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ousmane
 */
@Stateless
public class RdvDao implements IRdvDao {

    @PersistenceContext(name = "UP")
    protected EntityManager em ;
   
    @Override
    public Rdv getOne(Long id) {
        return em.find(Rdv.class, id) ;
    }
    
    @Override
     public Long create(Rdv rdv){
        em.persist(rdv);
        return rdv.getId() ;
    }
    
    
    @Override
    public void update(Rdv a)
    {
        em.merge(a) ;
    }
    
    @Override
    public boolean exists(Rdv a){
        return em.contains(a) ;
    }
    
    @Override
    public void delete(Rdv a)
    {
        em.remove(a);
    }
}
