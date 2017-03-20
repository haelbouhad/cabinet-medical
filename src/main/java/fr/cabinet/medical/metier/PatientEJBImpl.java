/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Patient;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hassan
 */
@Stateless(name="PAT")
public class PatientEJBImpl implements IPatientLocal, IPatientRemote {

    @PersistenceContext(unitName = "UP")
    private EntityManager em;

    @Override
    public Long addPatient(Patient p) {
        em.persist(p);
        return p.getCode();
    }

    @Override
    public List<Patient> getAllPatients() {
        Query req = em.createQuery("select p from Patient p");
        return req.getResultList();
    }   

    @Override
    public Patient getPatient(Long code) {
        Patient p = em.find(Patient.class, code);
        if(p == null)
            throw new RuntimeException("Patient introuvable");
        return p;
    }   

    @Override
    public void supprimerPatient(Long code) {
        Patient p = em.find(Patient.class, code);
        em.remove(p);
    }
    
 
}
