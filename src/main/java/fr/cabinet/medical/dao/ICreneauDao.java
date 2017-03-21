/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Medecin;
import java.util.List;

/**
 *
 * @author ousmane
 */
public interface ICreneauDao {

    Long create(Creneau c);

    void delete(Creneau c);

    boolean exists(Creneau c);

    List<Creneau> getCrenauxLibres(Medecin medecin);

    List<Creneau> getCrenauxLibres();

    Creneau getOne(Long id);

    void update(Creneau c);
    
}
