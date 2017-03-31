/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import fr.cabinet.medical.dao.IMedecinDao;
import fr.cabinet.medical.entities.Medecin;
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
@Path("/medecins")
@Produces(MediaType.APPLICATION_JSON)
public class MedecinRestService {
    
    private static final Logger LOGGER = Logger.getLogger(MedecinRestService.class.getName()) ;
    
    @EJB
    private IMedecinDao medecinDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Long create(Medecin m)
    {
        LOGGER.log(Level.INFO, "POST /medecins");
        return medecinDao.create(m) ;
    }

    @GET
    public List<Medecin> getAll() {
        LOGGER.log(Level.INFO, "GET /medecins");
        return medecinDao.getAll();
    }

    @GET
    @Path("/{id}")
    public Medecin getOne(@PathParam(value = "id") Long id) {
        LOGGER.log(Level.INFO, "GET /medecins/{0}", id);
        return medecinDao.getOne(id) ;
    }
    
    @Path("/{id}")
    @PUT
    public void update(@PathParam("id") Long id, Medecin m) 
    {
        LOGGER.log(Level.INFO, "PUT /medecins/{0}", id);
        LOGGER.log(Level.INFO, m.toString());
        if(m.getId() == null || !Objects.equals(m.getId(), id)) throw new BadRequestException() ;
        Medecin med = medecinDao.getOne(id) ;
        med.setNom(m.getNom());
        med.setPrenom(m.getPrenom());
        medecinDao.update(m);
    }
    
    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") Long id)
    {
        LOGGER.log(Level.INFO, "DELETE /medecins/{0}", id);
        medecinDao.delete(id);
    }
}
