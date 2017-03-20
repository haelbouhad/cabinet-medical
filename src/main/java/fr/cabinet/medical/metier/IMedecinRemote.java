/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.metier;

import fr.cabinet.medical.entities.Medecin;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author hassan
 */
@Remote
public interface IMedecinRemote {
    public Long addMedecin(Medecin m);
    public List<Medecin> getAllMedecins();
    public Medecin getMedecin(Long code);
    public void supprimerMedecin(Long code);
}
