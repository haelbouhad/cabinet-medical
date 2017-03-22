/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Medecin;
import java.util.List;

/**
 *
 * @author ousmane
 */
public interface IMedecinDao {

    Long create(Medecin a);

    void delete(Long id);

    boolean exists(Medecin a);

    List<Medecin> getAll();

    Medecin getOne(Long id);

    void update(Medecin a);
    
}
