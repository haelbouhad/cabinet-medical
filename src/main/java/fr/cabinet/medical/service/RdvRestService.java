/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.IRdvDao;
import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Patient;
import fr.cabinet.medical.entities.Rdv;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
 * @author ousmane
 */

@Path("/rdvs")
@Produces(MediaType.APPLICATION_JSON)
public class RdvRestService {
    
    private static final Logger LOGGER = Logger.getLogger(RdvRestService.class.getName()) ;
    
    @EJB
    private IRdvDao rdvDao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(Rdv r) {
        LOGGER.log(Level.INFO, "POST /rdvs");
        return rdvDao.create(r);
    }
    
    @GET
    public List<Rdv> getAll() {
        LOGGER.log(Level.INFO, "GET /rdvs");
        return rdvDao.getAll();
    }
    
    /*
    @POST
    @Path("/takeRDV")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void takeRDV(@FormParam("date") String d , @FormParam("code") Long codePatient) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");        
        Date date;        
        try { 
            date = df.parse(d);
        } catch (Exception ex) {
            throw new RuntimeException("Error date format");
        }
        rdvDao.takeRDV(date, codePatient);            
    }

    @GET
    @Path("/annulerRDV/{code}")
    public void annulerRDV(@PathParam(value = "code") Long code) {
        rdvDao.annulerRDV(code);
    }
    
    @POST
    @Path("/editRDV")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void editRDV(@FormParam("code") Long code, @FormParam("date") String newDate ) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = df.parse(newDate);
            rdvDao.editRDV(code, date);
        } catch (ParseException ex) {
            throw new RuntimeException("Error date format");
        }
    }
    
    @GET
    @Path("/getAllRDV")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rdv> getAllRDV() {
        return rdvDao.getAllRDV();
    }
    */
}
