/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.ICreneauDao;
import fr.cabinet.medical.dao.IRdvDao;
import fr.cabinet.medical.entities.Creneau;
import fr.cabinet.medical.entities.Patient;
import fr.cabinet.medical.entities.Rdv;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
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
 * @author ousmane
 */

@Path("/creneaux")
@Produces(MediaType.APPLICATION_JSON)
public class CreneauRestService {
    
    private static final Logger LOGGER = Logger.getLogger(PatientRestService.class.getName()) ;
    
    @EJB
    private ICreneauDao creneauDao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(Creneau c) {
        LOGGER.log(Level.INFO, "POST /creneaux");
        return creneauDao.create(c);
    }
    
    @GET
    public List<Creneau> getCreneaux() {
        LOGGER.log(Level.INFO, "GET /creneaux");
        return creneauDao.getCrenauxLibres();
    }
    
    @Path("/{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(@PathParam("id") Long id, Creneau c) 
    {
        LOGGER.log(Level.INFO, "PUT /creneaux/{0}", id);
        if(c.getId() == null || !Objects.equals(c.getId(), id)) throw new BadRequestException() ;
        Creneau creneau = creneauDao.getOne(id) ;
        creneau.setDebut(c.getDebut());
        creneau.setFin(c.getFin());
        creneauDao.update(creneau);
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
