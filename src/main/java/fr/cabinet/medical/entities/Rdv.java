/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.cabinet.medical.entities;


import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


/**
 *
 * @author hassan
 */
@Entity
public class Rdv implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Date date;
    
    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;
    
    @ManyToOne
    @JoinColumn(name = "id_creneau")
    private Creneau creneau;

    public Rdv() {
    }

    public Rdv(Date date, Patient patient) {
        this.date = date;
        this.patient = patient;
    }
    
    

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Patient getPatient() {
        return patient;
    }

    public Creneau getCreneau() {
        return creneau;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setCreneau(Creneau creneau) {
        this.creneau = creneau;
    }

}
