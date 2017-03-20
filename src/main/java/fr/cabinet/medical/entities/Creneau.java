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

/**
 *
 * @author hassan
 */
@Entity
public class Creneau implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Code;

    private Date debut;
    
    private Date fin;
    
    @ManyToOne
    @JoinColumn(name = "code_medecin")
    private Medecin medecin;
    
    @OneToMany(mappedBy = "creneau", fetch = FetchType.LAZY)
    private Collection<Rdv> rdvs;

    public Creneau() {
    }

    public Creneau(Date debut, Date fin, Medecin medecin) {
        this.debut = debut;
        this.fin = fin;
        this.medecin = medecin;
    }

    public Long getCode() {
        return Code;
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

    public Collection<Rdv> getRdvs() {
        return rdvs;
    }

    public void setCode(Long Code) {
        this.Code = Code;
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

    public void setRdvs(Collection<Rdv> rdvs) {
        this.rdvs = rdvs;
    }

    
    
    
    
}
