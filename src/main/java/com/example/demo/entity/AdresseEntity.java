package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "adresse")
public class AdresseEntity {
    @Id
    private int id_adresse;
    private String libelle;
    private int id_concessionaire;

    public AdresseEntity(){}

    public int getId_adresse() {
        return id_adresse;
    }

    public void setId_adresse(int id_adresse) {
        this.id_adresse = id_adresse;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getId_concessionaire() {
        return id_concessionaire;
    }

    public void setId_concessionaire(int id_concessionaire) {
        this.id_concessionaire = id_concessionaire;
    }
}
