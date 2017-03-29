/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.service;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author hassan
 */
@ApplicationPath("/ws")
public class RestApplication extends Application {
    
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> service = new HashSet<>();
        
        service.add(CreneauRestService.class);
        service.add(RdvRestService.class);
        service.add(MedecinRestService.class);
        service.add(PatientRestService.class);
                
        return service;
    }
}
