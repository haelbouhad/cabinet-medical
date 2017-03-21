/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.IPatientDao;
import fr.cabinet.medical.entities.Medecin;
import fr.cabinet.medical.entities.Patient;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author hassan
 */

@Path("/patients")
@Produces(MediaType.APPLICATION_JSON)
public class PatientRestService {
    
    private static final Logger LOGGER = Logger.getLogger(PatientRestService.class.getName()) ;
    
    @EJB
    private IPatientDao patientDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long addPatient(Patient p) {
        return patientDao.create(p);
    }

    @GET
    public List<Patient> getAll() {
        LOGGER.log(Level.INFO, "GET /patients");
        return patientDao.getAll() ;
    }

    @GET
    @Path("/{id}")
    public Patient getOne(@PathParam(value = "id") Long id) {
        LOGGER.log(Level.INFO, "GET /patients/{0}", id);
        return patientDao.getOne(id) ;
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Patient p) 
    {
        LOGGER.log(Level.INFO, "PUT /patients/{0}", id);
        LOGGER.log(Level.INFO, p.toString());
        if(p.getId() == null || !Objects.equals(p.getId(), id)) throw new BadRequestException() ;
        Patient patient = patientDao.getOne(id) ;
        patient.setNom(p.getNom());
        patient.setPrenom(p.getPrenom());
        patientDao.update(patient);
    }
    
    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Long id)
    {
        LOGGER.log(Level.INFO, "DELETE /patients/{0}", id);
        patientDao.delete(id);
    }    
}
