/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Patient;
import java.util.List;

/**
 *
 * @author ousmane
 */
public interface IPatientDao {

    Long create(Patient p);

    void delete(Long id);

    boolean exists(Patient p);

    List<Patient> getAll();

    Patient getOne(Long id);

    void update(Patient p);
    
}
