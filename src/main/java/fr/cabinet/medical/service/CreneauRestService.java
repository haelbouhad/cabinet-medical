/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.ICreneauDao;
import fr.cabinet.medical.entities.Creneau;
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
    
    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Long id)
    {
        LOGGER.log(Level.INFO, "DELETE /creneaux/{0}", id);
        creneauDao.delete(id);
    }  
   
}
