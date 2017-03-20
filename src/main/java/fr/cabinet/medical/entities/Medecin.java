/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



/**
 *
 * @author hassan
 */
@Entity
public class Medecin  implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    
    private String nom;
    
    private String prenom;
    
    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private Collection<Creneau> crenaux;

    public Medecin() {
    }

    public Medecin(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Long getCode() {
        return code;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @JsonIgnore
    public Collection<Creneau> getCrenaux() {
        return crenaux;
    }

    @JsonIgnore
    public void setCrenaux(Collection<Creneau> crenaux) {
        this.crenaux = crenaux;
    }
   
}
