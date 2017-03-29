/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.dao;

import fr.cabinet.medical.entities.Rdv;
import java.util.List;

/**
 *
 * @author ousmane
 */
public interface IRdvDao {

    Long create(Rdv rdv);

    void delete(Rdv rdv);

    boolean exists(Rdv rdv);

    Rdv getOne(Long id);

    void update(Rdv rdv);
    
    List<Rdv> getAll();
    
}
