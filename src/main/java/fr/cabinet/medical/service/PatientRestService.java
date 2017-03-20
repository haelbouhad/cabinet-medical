/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.entities.Patient;
import fr.cabinet.medical.metier.IPatientLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hassan
 */

@Stateless
@Path("/patient")
public class PatientRestService {
    
    @EJB
    private IPatientLocal metier;

    @GET
    @Path("/add/{nom}/{prenom}")
    public Long addPatient(@PathParam(value = "nom") String nom, @PathParam(value = "prenom") String prenom) {
        return metier.addPatient(new Patient(nom, prenom));
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients() {
        return metier.getAllPatients();
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Patient getPatient(@PathParam(value = "code") Long code) {
        return metier.getPatient(code);
    }

    @GET
    @Path("/remove/{code}")
    public void supprimerPatient(@PathParam(value = "code") Long code) {
        metier.supprimerPatient(code);
    }
    
    
}
