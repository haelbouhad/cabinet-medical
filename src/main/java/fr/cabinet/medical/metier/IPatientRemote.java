/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Patient;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author hassan
 */
@Remote
public interface IPatientRemote {
    public Long addPatient(Patient p);
    public List<Patient> getAllPatients();
    public Patient getPatient(Long code);
    public void supprimerPatient(Long code);
}
