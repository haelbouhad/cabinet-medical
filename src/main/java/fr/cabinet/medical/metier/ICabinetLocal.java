/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Patient;
import fr.cabinet.medical.entities.Rdv;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author hassan
 */
@Local
public interface ICabinetLocal {
    
    public void addCreneau(Date debut, Date fin, Long codeMedecin);
    public void removeCreneau(Long code);
    public List<Creneau> getAllCreneau();
    public void takeRDV(Date d, Long codePatient);
    public void annulerRDV(Long code);
    public void editRDV(Long code, Date newDate);
    public List<Rdv> getAllRDV();
    
}
