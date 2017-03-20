/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Medecin;
import fr.cabinet.medical.entities.Patient;
import fr.cabinet.medical.entities.Rdv;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author hassan
 */
@Stateless(name = "CAB")
public class CabinetEJBImpl implements ICabinetLocal {

    @PersistenceContext(unitName = "UP")
    private EntityManager em;
    
    @Override
    public void addCreneau(Date debut, Date fin, Long code) {
        Medecin m = em.find(Medecin.class, code);
        if( m == null)
            throw new RuntimeException("Médecin introuvable");
        em.persist(new Creneau(debut, fin, m));
    }

    @Override
    public void removeCreneau(Long code) {
        Creneau creneau = em.find(Creneau.class, code);
        em.remove(creneau);
    }

    @Override
    public List<Creneau> getAllCreneau() {
        Query q = em.createQuery("select c from Creneau c");
        return q.getResultList();
    }

    @Override
    public void takeRDV(Date d, Long codePatient) {
        Query q = em.createQuery("select r from Rdv r where r.date = :x");
        q.setParameter("x", d);
        List<Rdv> rdvs = q.getResultList();
        if(!rdvs.isEmpty())
            throw new RuntimeException("le rendez-vous est déjà pris");
        Patient p = em.find(Patient.class, codePatient);
        em.persist(new Rdv(d, p));
    }

    @Override
    public void annulerRDV(Long code) {
        Rdv rdv = em.find(Rdv.class, code);
        em.remove(rdv);
    }

    @Override
    public void editRDV(Long code, Date newDate) {
        Query q = em.createQuery("select r from Rdv r where r.patient.code = :x");
        q.setParameter("x", code);
        Rdv r = (Rdv) q.getSingleResult();
        r.setDate(newDate);
        em.persist(r);
    }

    @Override
    public List<Rdv> getAllRDV() {
        Query q = em.createQuery("select r from Rdv r");
        return q.getResultList();
    }
    
}
