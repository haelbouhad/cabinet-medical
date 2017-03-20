/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Rdv;
import fr.cabinet.medical.metier.ICabinetLocal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author hassan
 */

@Stateless
@Path("/cm")
public class CabinetRestService {
    
    @EJB
    private ICabinetLocal metier;

    @POST
    @Path("/addCreneau")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addCreneau(@FormParam("debut") String d, @FormParam("fin") String f, @FormParam("code") Long codeMedecin) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date debut = df.parse(d);
            Date fin   = df.parse(f);
            metier.addCreneau(debut, fin, codeMedecin);
        } catch (ParseException ex) {
            throw new RuntimeException("Date error format");
        }        
    }

    @GET
    @Path("/getAll")
    public List<Creneau> getAllCreneau() {
        List<Creneau> list = metier.getAllCreneau();
        return list;
    }
    
    @POST
    @Path("/takeRDV")
    public void takeRDV(@FormParam("date") String d , @FormParam("code") Long codePatient) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");        
        Date date;        
        try { 
            date = df.parse(d);
        } catch (Exception ex) {
            throw new RuntimeException("Error date format");
        }
        metier.takeRDV(date, codePatient);            
    }

    @GET
    @Path("/annulerRDV/{code}")
    public void annulerRDV(@PathParam(value = "code") Long code) {
        metier.annulerRDV(code);
    }
    
    @POST
    @Path("/editRDV")
    public void editRDV(@FormParam("code") Long code, @FormParam("date") String newDate ) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = df.parse(newDate);
            metier.editRDV(code, date);
        } catch (ParseException ex) {
            throw new RuntimeException("Error date format");
        }
    }
    
    @GET
    @Path("/getAllRDV")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rdv> getAllRDV() {
        return metier.getAllRDV();
    }
    
}
