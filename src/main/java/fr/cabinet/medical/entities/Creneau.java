/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.entities;



import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author hassan
 */
@Entity
public class Creneau implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date debut;
    
    private Date fin;
    
    @ManyToOne
    @JoinColumn(name = "id_medecin") 
    private Medecin medecin;
    
    @JsonIgnore
    @OneToMany(mappedBy = "creneau", fetch = FetchType.LAZY)
    private Collection<Rdv> rdvs;

    public Creneau() {
    }

    public Creneau(Date debut, Date fin, Medecin medecin) {
        this.debut = debut;
        this.fin = fin;
        this.medecin = medecin;
    }

    public Long getId() {
        return id;
    }

    public Date getDebut() {
        return debut;
    }

    public Date getFin() {
        return fin;
    }


    public Medecin getMedecin() {
        return medecin;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }


    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }  
    
}
