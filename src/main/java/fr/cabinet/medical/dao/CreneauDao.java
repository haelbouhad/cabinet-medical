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
import javax.persistence.Query;

/**
 *
 * @author ousmane
 */
@Stateless
public class CreneauDao implements ICreneauDao {
    
    @PersistenceContext(name = "UP")
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
        return this.em.createQuery("SELECT c FROM Creneau c WHERE c.rdvs is empty ").getResultList() ;
    }

    @Override
    public Creneau getOne(Long id) {
        return em.find(Creneau.class, id) ;
    }
    
    @Override
     public Long create(Creneau c){
        Query q = em.createQuery("SELECT c FROM Creneau c "
                + "WHERE c.medecin = :medecin "
                + "AND ( (c.debut <= :new_fin AND c.debut > :new_debut ) OR ( c.fin > :new_debut AND c.fin <= :new_fin ) ) ");
        q.setParameter("medecin", c.getMedecin());
        q.setParameter("new_debut", c.getDebut());
        q.setParameter("new_fin", c.getFin());
        List<Creneau> conflict = q.getResultList();
        if(conflict.size() > 0 )
            throw new RuntimeException("Le médecin n'est pas disponible pour ce créneau");
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
    public void delete(Long id)
    {
        Creneau c = em.getReference(Creneau.class, id) ;
        em.remove(c);
    }
    
}
