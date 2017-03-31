/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ousmane
 */
@Stateless
public class PatientDao implements IPatientDao {

    @PersistenceContext(name = "UP")
    protected EntityManager em ;
    
    @Override
    public Patient getOne(Long id) {
        return em.find(Patient.class, id) ;
    }
    
    @Override
     public Long create(Patient p){
        em.persist(p);
        return p.getId() ;
    }
    
    
    @Override
    public void update(Patient a)
    {
        em.merge(a) ;
    }
    
    @Override
    public boolean exists(Patient a){
        return em.contains(a) ;
    }
    
    @Override
    public void delete(Long id)
    {
        Patient p = em.getReference(Patient.class, id) ;
        em.remove(p);
    }
    
    @Override
    public List<Patient> getAll() {
        return em.createQuery("SELECT p FROM Patient p").getResultList() ;
    }
}


