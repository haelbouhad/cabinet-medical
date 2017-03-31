/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.IRdvDao;
import fr.cabinet.medical.entities.Rdv;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
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
    
    @GET
    @Path("/{id}")
    public Rdv getOne(@PathParam(value = "id") Long id) {
        LOGGER.log(Level.INFO, "GET /rdvs/{0}", id);
        return rdvDao.getOne(id) ;
    }
    
    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Long id)
    {
        LOGGER.log(Level.INFO, "DELETE /rdvs/{0}", id);
        rdvDao.delete(id);
    } 
}
