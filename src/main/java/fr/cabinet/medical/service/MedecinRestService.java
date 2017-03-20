/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.entities.Medecin;
import fr.cabinet.medical.metier.IMedecinLocal;
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
@Path("/medecin")
public class MedecinRestService {
    
    @EJB
    private IMedecinLocal metier;

    @GET
    @Path("/add/{nom}/{prenom}")
    public Long addMedecin(@PathParam(value = "nom") String nom, @PathParam(value = "prenom") String prenom) {
        return metier.addMedecin(new Medecin(nom, prenom));
    }

    @GET
    @Path("/getAll")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Medecin> getAllMedecins() {
        return metier.getAllMedecins();
    }

    @GET
    @Path("/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Medecin getMedecin(@PathParam(value = "code") Long code) {
        return metier.getMedecin(code);
    }

    @GET
    @Path("/remove/{code}")
    public void supprimerMedecin(@PathParam(value = "code") Long code) {
        metier.supprimerMedecin(code);
    }
    
    
    
}
